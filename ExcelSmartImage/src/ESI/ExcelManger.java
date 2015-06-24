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
		//加载Excel
		ExcelWorkbook = ExcelOperator.load(path);
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
			Cell SerialCell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelSearchKeyList(), DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
			//
			if (SerialCell != null)
			{
				System.out.println("已定位目标编码列");
				Cell imagecell = ExcelOperator.SearchValueInSheet(sheet, DataManager.getExcelImageKeyPhraseList(),DataManager.getSearchBoundary().getRowIndex(), DataManager.getSearchBoundary().getColIndex());
				if (imagecell!=null)
				{
					System.out.println("已定位目标图片列");
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
			cal = Calendar.getInstance();
			FileOutputStream fileOut = new FileOutputStream(path.substring(0,path.lastIndexOf(".")-1) + "-"
					+ sdf.format(cal.getTime()) + path.substring(path.lastIndexOf(".")));
			
			ExcelWorkbook.write(fileOut);
			fileOut.close();
			ExcelWorkbook.close();
			ESIUIManager.printInfo("完成");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
			
	}
	
	private static void RetriveImage()
	{
		ESIUIManager.printInfo("加载图片列表");
		System.out.println("开始加载图片");
		//初始化图片列表
		ImageFilelist = new ArrayList<ImageData>();
		//获取所有图片库路径
		for (String str : DataManager.getImagePathList())
		{
			retriveImageFromPath(str,ImageFilelist);
		}
		ESIUIManager.getMainWindow().getLblImageFileNum().setText(Integer.toString(ImageFilelist.size()));
		System.out.println("图片加载完成");
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
		ESIUIManager.printInfo("加载Excel列表");
		System.out.println("开始加载列表");
		ExcelFilelist = new ArrayList<String>();
		//获取所有图片库路径
		util.FileOperator.RecurseFileToList(ESIData.DataManager.getExcelPathList(), ESIData.DataManager.getExcelSupportList(),ExcelFilelist);
		ESIUIManager.getMainWindow().getLblExcelFileNum().setText(Integer.toString(ExcelFilelist.size()));		
		System.out.println("Excel列表加载完成");
	}
	
	
}
