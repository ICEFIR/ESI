package ESI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import ESIObjects.ImageData;
import ui.ESIUIManager;
import util.ExcelOperator;
import util.FileOperator;

public class ExcelManger {
	
	private static Workbook ExcelWorkbook = null;
	
	public static void Start()
	{
		
		RetriveImage();
		
		
		if (DataManager.getImageList().size() == 0)
		{
			ESIUIManager.printInfo("δ�����κ�ͼƬ");
			return;
		}
		//��������
		SettingRetriver.LoadSettingFromUI();
		ESIUIManager.printInfo("�����Ѽ���");
		
		
		if (FileOperator.checkIsFile(ESIUIManager.getMainWindow().getTxtExcel().getText()))
		{
			ESIUIManager.printInfo(DataManager.getExcelFileList().size());
			for (int ExcelNum = 0; ExcelNum < DataManager.getExcelFileList().size();ExcelNum++)
			{
				
				//����Excel
				ExcelWorkbook = ExcelOperator.load(DataManager.getExcelFileList().get(ExcelNum));
				
				if (ExcelWorkbook == null)
				{
					//�������ʧ�����˳�
					return;
				}
				ESIUIManager.printInfo("Excel����Ѽ���");
				//��Ѱ�����������еı��
				for (int i = 0; i < ExcelWorkbook.getNumberOfSheets(); i++)
				{
					//-------
					CreationHelper helper =ExcelWorkbook.getCreationHelper();
					//-------
					Sheet sheet = ExcelWorkbook.getSheetAt(i);
					//Ѱ�ҵ�Ԫ��
					Cell ImageNameCell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelSearchKeyList(), DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
					//
					if (ImageNameCell != null)
					{
						System.out.println("�Ѷ�λĿ��ͼƬ��");
						Cell imagecell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelImagePositionKeyList(),DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
						if (imagecell!=null)
						{
							//sheet.setColumnWidth(imagecell.getColumnIndex(),(int) (Math.ceil(DataManager.getImageSize().getWidth()*0.026458*4.7237*256)));
							sheet.setColumnWidth(imagecell.getColumnIndex(), (int) (8.3*256));
							//-----
							Drawing drawing = sheet.createDrawingPatriarch();
							//-----
							for (Row row : sheet)
							{
								if (row.getRowNum()>ImageNameCell.getRowIndex())
								{
									//row.removeCell(row.getCell(imagecell.getColumnIndex()));
									row.createCell(imagecell.getColumnIndex());
									//row.setHeight((short) (Math.ceil(DataManager.getImageSize().getHeight()/96*72*20)));
									row.setHeight((short) (50*20));
									String pathofimage = new String();
									try
									{
										pathofimage = 	DataManager.SearchImageList(ExcelOperator.getCellValue(row.getCell(ImageNameCell.getColumnIndex())));
									} catch (Exception e)
									{
										pathofimage = null;
									}
									
									if (pathofimage!=null)
									{
										System.out.println("Image Found:" + pathofimage);
										File file = new File("temp.jpg");
										if(file.exists()) file.delete();
										
										try {
											Thumbnails.of(pathofimage).forceSize(DataManager.getImageSize().getWidth(), DataManager.getImageSize().getHeight()).outputFormat("jpg").toFile("temp.jpg");
											//-----
						
											ClientAnchor anchor = helper.createClientAnchor();  
											//-----
											//-----
											InputStream is = new FileInputStream("temp.jpg");  
											byte[] bytes = IOUtils.toByteArray(is);  
											int pictureIdx = ExcelWorkbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG); 
											anchor.setCol1(imagecell.getColumnIndex());  
											anchor.setRow1(row.getRowNum()); 
											Picture pict = drawing.createPicture(anchor, pictureIdx);  
											pict.resize(1.0,1.0);
											//----
											 
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
										
								}
									
							}
							
						}else{
							ESIUIManager.printInfo("��ȷ��ͼƬ�����е��Ҳ���ָ��ͼƬ��");
							return;
						}
					}
				}
				
				//ESIUIManager.printInfo("�Ҳ���ָ��ͼƬ��������");
				
				File file = new File("temp.jpg");
				if(file.exists()) file.delete();
				try {
					//FileOutputStream fileOut = new FileOutputStream( DataManager.getExcelFileList().get(ExcelNum) );
					String str = DataManager.getExcelFileList().get(ExcelNum);
					FileOutputStream fileOut = new FileOutputStream("result." + str.substring(str.lastIndexOf(".")+1));
					
					ExcelWorkbook.write(fileOut);
					fileOut.close();
					ExcelWorkbook.close();
					ESIUIManager.printInfo("���");
					File file1 = new File("result." + str.substring(str.lastIndexOf(".")+1));
					Runtime r = Runtime.getRuntime();  
		            r.exec("cmd /c start " + file1.getAbsolutePath());  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		}else
		{
			ESIUIManager.printInfo("�ļ�������");
			return;
		}
	}
	
	
	
	
	
	
	private static void RetriveImage()
	{
		ESIUIManager.printInfo("Retriving image list");
		System.out.println("��ʼ����ͼƬ");
		//��ʼ��ͼƬ�б�
		DataManager.getImagePathList().clear();
		//���ͼƬ�б�
		if (FileOperator.checkExist(ESIUIManager.getMainWindow().getTxtImagePath().getText())) 
		{
			DataManager.getImagePathList().add(ESIUIManager.getMainWindow().getTxtImagePath().getText());
		} else
		{
			ESIUIManager.printInfo("�����ͼƬ��·��" + ESIUIManager.getMainWindow().getTxtImagePath().getText() + "������");
			return;
		}
		//��ȡ����ͼƬ��·��
		for (String str : DataManager.getImagePathList())
		{
			getAllImageFromPathToList(str);
		}
		System.out.println("ͼƬ�������");
	}
	private static void getAllImageFromPathToList(String path) 
	//���������ļ��У�����ͼƬ����ӵ��б�
	{
		 File file = new File(path);
		 File[] files = file.listFiles();
		 for (File fl : files)
		 {
			   if (fl.isDirectory())
			   {
				   //���������ļ������ļ��е�
				   getAllImageFromPathToList(fl.getAbsolutePath());  
			   }
			   else
			   {
				   //�ж��Ƿ�ͼƬ
				   for (String str:DataManager.getImageSupportList())
					   if (fl.getName().toLowerCase().endsWith(str))
					   {
						   ImageData imagedata = new ImageData();
						   imagedata.setName(fl.getName().substring(0, fl.getName().lastIndexOf(".")));
						   imagedata.setPath(fl.getAbsolutePath());
						   DataManager.getImageList().add(imagedata);
					   }
			   }
		  }
	}
	
	
}
