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
			ESIUIManager.printInfo("未发现任何图片");
			return;
		}
		//加载配置
		SettingRetriver.LoadSettingFromUI();
		ESIUIManager.printInfo("配置已加载");
		
		
		if (FileOperator.checkIsFile(ESIUIManager.getMainWindow().getTxtExcel().getText()))
		{
			ESIUIManager.printInfo(DataManager.getExcelFileList().size());
			for (int ExcelNum = 0; ExcelNum < DataManager.getExcelFileList().size();ExcelNum++)
			{
				
				//加载Excel
				ExcelWorkbook = ExcelOperator.load(DataManager.getExcelFileList().get(ExcelNum));
				
				if (ExcelWorkbook == null)
				{
					//如果加载失败则退出
					return;
				}
				ESIUIManager.printInfo("Excel表格已加载");
				//搜寻工作薄内所有的表格
				for (int i = 0; i < ExcelWorkbook.getNumberOfSheets(); i++)
				{
					//-------
					CreationHelper helper =ExcelWorkbook.getCreationHelper();
					//-------
					Sheet sheet = ExcelWorkbook.getSheetAt(i);
					//寻找单元格
					Cell ImageNameCell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelSearchKeyList(), DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
					//
					if (ImageNameCell != null)
					{
						System.out.println("已定位目标图片列");
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
							ESIUIManager.printInfo("已确认图片名称列但找不到指定图片列");
							return;
						}
					}
				}
				
				//ESIUIManager.printInfo("找不到指定图片名称内容");
				
				File file = new File("temp.jpg");
				if(file.exists()) file.delete();
				try {
					//FileOutputStream fileOut = new FileOutputStream( DataManager.getExcelFileList().get(ExcelNum) );
					String str = DataManager.getExcelFileList().get(ExcelNum);
					FileOutputStream fileOut = new FileOutputStream("result." + str.substring(str.lastIndexOf(".")+1));
					
					ExcelWorkbook.write(fileOut);
					fileOut.close();
					ExcelWorkbook.close();
					ESIUIManager.printInfo("完成");
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
			ESIUIManager.printInfo("文件不存在");
			return;
		}
	}
	
	
	
	
	
	
	private static void RetriveImage()
	{
		ESIUIManager.printInfo("Retriving image list");
		System.out.println("开始加载图片");
		//初始化图片列表
		DataManager.getImagePathList().clear();
		//添加图片列表
		if (FileOperator.checkExist(ESIUIManager.getMainWindow().getTxtImagePath().getText())) 
		{
			DataManager.getImagePathList().add(ESIUIManager.getMainWindow().getTxtImagePath().getText());
		} else
		{
			ESIUIManager.printInfo("错误的图片库路径" + ESIUIManager.getMainWindow().getTxtImagePath().getText() + "，请检查");
			return;
		}
		//获取所有图片库路径
		for (String str : DataManager.getImagePathList())
		{
			getAllImageFromPathToList(str);
		}
		System.out.println("图片加载完成");
	}
	private static void getAllImageFromPathToList(String path) 
	//遍历所有文件夹，查找图片并添加到列表
	{
		 File file = new File(path);
		 File[] files = file.listFiles();
		 for (File fl : files)
		 {
			   if (fl.isDirectory())
			   {
				   //遍历所有文件，子文件夹等
				   getAllImageFromPathToList(fl.getAbsolutePath());  
			   }
			   else
			   {
				   //判断是否图片
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
