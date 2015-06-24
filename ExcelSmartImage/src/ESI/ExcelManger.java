package ESI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

import ESIData.DataManager;
import ESIObjects.ImageData;
import ui.ESIUIManager;
import util.ExcelOperator;
import util.FileOperator;

public class ExcelManger {
	private static List<ImageData> ImageFilelist;
	private static List<String> ExcelFilelist;
	private static Workbook ExcelWorkbook = null;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
	private static Calendar cal;
	
	public static void start()
	{
		RetriveImage();
		RetriveExcel();

		int i = 0;
		for(String str : ExcelFilelist)
		{
			i++;
			if (FileOperator.checkIsFile(str) && valid_file(str))
			{
				excel_process(str);
			}
			ESIUIManager.getMainWindow().getLblOveralProcess().setText(i + "/" + ExcelFilelist.size());
			ESIUIManager.getMainWindow().getOveralProcessBar().setValue(i/ExcelFilelist.size()*100);
			
		}

	}
	
	private static boolean valid_file(String str)
	{
		return false;
	}
	public static void excel_process(String path)
	{
		//����Excel
		ExcelWorkbook = ExcelOperator.load(path);
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
			Cell SerialCell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelSearchKeyList(), DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
			//
			if (SerialCell != null)
			{
				System.out.println("�Ѷ�λĿ�������");
				Cell imagecell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelImageKeyPhraseList(),DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
				if (imagecell!=null)
				{
					System.out.println("�Ѷ�λĿ��ͼƬ��");
					//sheet.setColumnWidth(imagecell.getColumnIndex(),(int) (Math.ceil(DataManager.getImageSize().getWidth()*0.026458*4.7237*256)));
					sheet.setColumnWidth(imagecell.getColumnIndex(), (int) (8.3*256));
					//-----
					Drawing drawing = sheet.createDrawingPatriarch();
					//-----
					for (Row row : sheet)
					{
						ESIUIManager.getMainWindow().getLblCurrentProcess().setText(row.getRowNum() + "/" + sheet.getLastRowNum());
						ESIUIManager.getMainWindow().getCurrentProcessBar().setValue(row.getRowNum()/sheet.getLastRowNum()*100);
						if (row.getRowNum()>SerialCell.getRowIndex())
						{
							//row.removeCell(row.getCell(imagecell.getColumnIndex()));
							row.createCell(imagecell.getColumnIndex());
							//row.setHeight((short) (Math.ceil(DataManager.getImageSize().getHeight()/96*72*20)));
							row.setHeight((short) (50*20));
							String pathofimage = new String();
							try
							{
								pathofimage = DataManager.SearchImageList(ExcelOperator.getCellValue(row.getCell(SerialCell.getColumnIndex())),ImageFilelist);
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
			cal = Calendar.getInstance();
			FileOutputStream fileOut = new FileOutputStream(path.substring(0,path.lastIndexOf(".")-1) + "-"
					+ sdf.format(cal.getTime()) + path.substring(path.lastIndexOf(".")));
			
			ExcelWorkbook.write(fileOut);
			fileOut.close();
			ExcelWorkbook.close();
			ESIUIManager.printInfo("���");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
			
	}
	
	private static void RetriveImage()
	{
		ESIUIManager.printInfo("����ͼƬ�б�");
		System.out.println("��ʼ����ͼƬ");
		//��ʼ��ͼƬ�б�
		ImageFilelist = new ArrayList<ImageData>();
		//��ȡ����ͼƬ��·��
		for (String str : DataManager.getImagePathList())
		{
			retriveImageFromPath(str,ImageFilelist);
		}
		ESIUIManager.getMainWindow().getLblImageFileNum().setText(Integer.toString(ImageFilelist.size()));
		System.out.println("ͼƬ�������");
	}
	
	private static void retriveImageFromPath(String str, List<ImageData> list)
	{
		List<String> ImageList = new ArrayList<String>();
		util.FileOperator.RecurseFileToList(ESIData.DataManager.getImagePathList(), ESIData.DataManager.getImageSupportList(), ImageList);
		for(String str1 : ImageList)
		{
			ImageData data = new ImageData();
			data.setName(util.FileOperator.getFileName(str1));
			data.setPath(str1);
			list.add(data);
		}
	}
	
	private static void RetriveExcel()
	{
		ESIUIManager.printInfo("����Excel�б�");
		System.out.println("��ʼ�����б�");
		ExcelFilelist = new ArrayList<String>();
		//��ȡ����ͼƬ��·��
		util.FileOperator.RecurseFileToList(ESIData.DataManager.getExcelPathList(), ESIData.DataManager.getExcelSupportList(),ExcelFilelist);
		ESIUIManager.getMainWindow().getLblExcelFileNum().setText(Integer.toString(ExcelFilelist.size()));		
		System.out.println("Excel�б�������");
	}
	
	
}
