package ESI;

import java.awt.EventQueue;
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

public class ExcelManager implements Runnable {
	private Workbook ExcelWorkbook = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
	private Calendar cal;
	private String suffix="-ESI";
	private Thread t;
	private String threadName;
	
	public ExcelManager( String name)
	{
       threadName = name;
       System.out.println("Creating " +  threadName );
	}
	
	public void run()  {
		List<String> ExcelFilelist = RetriveExcel();
		List<ImageData> ImageFilelist = RetriveImage();
		int i = 0;
		for(String str : ExcelFilelist)
		{
			i++;
			if (FileOperator.checkIsFile(str) && valid_file(str))
			{
				excel_process(str,ImageFilelist);
			}
			updateOverlCounterUI(i,ExcelFilelist.size());
		}
	}
	
	 public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	
	private boolean valid_file(String str)
	{
		if(str.substring(str.lastIndexOf(".")-4, str.lastIndexOf(".")).equals(suffix))
		{
			return false;
		}
		return true;
	}
	private void excel_process(String path, List<ImageData> ImageFilelist)
	{
		//����Excel
		ExcelWorkbook = ExcelOperator.load(path);
		if (ExcelWorkbook == null)
		{
			//�������ʧ�����˳�
			return;
		}
		System.out.println("Excel����Ѽ���");
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
					sheet.setColumnWidth(imagecell.getColumnIndex(), (int) (DataManager.getCellProperty().getCellWidthExcelUnit()*256));
					//sheet.setColumnWidth(imagecell.getColumnIndex(), (int) (((float)DataManager.getImageSize().getWidth())/7*256));
					//-----
					Drawing drawing = sheet.createDrawingPatriarch();
					//-----
					for (Row row : sheet)
					{
						updateCurrentlCounterUI(row.getRowNum(),sheet.getLastRowNum());
						
						if (row.getRowNum()>SerialCell.getRowIndex())
						{
							//row.removeCell(row.getCell(imagecell.getColumnIndex()));
							row.createCell(imagecell.getColumnIndex());
							//row.setHeight((short) (Math.ceil(DataManager.getImageSize().getHeight()/96*72*20)));
							row.setHeight((short) (20*DataManager.getCellProperty().getCellHeightExcelUnit()));
							//row.setHeight((short) (((float)DataManager.getImageSize().getHeight())/7*256*20));
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
					System.out.println("��ȷ��ͼƬ�����е��Ҳ���ָ��ͼƬ��");
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
			FileOutputStream fileOut = new FileOutputStream(path.substring(0,path.lastIndexOf(".")) + "-"
					+ sdf.format(cal.getTime()) + suffix + path.substring(path.lastIndexOf(".")));
			
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
	
	private List<ImageData> RetriveImage()
	{
		System.out.println("��ʼ����ͼƬ");
		//��ʼ��ͼƬ�б�
		List<ImageData> ImageFilelist = new ArrayList<ImageData>();
		//��ȡ����ͼƬ��·��
		for (String str : DataManager.getImagePathList())
		{
			retriveImageFromPath(str,ImageFilelist);
		}
		ESIUIManager.getMainWindow().getLblImageFileNum().setText(Integer.toString(ImageFilelist.size()));
		System.out.println("ͼƬ�������");
		return ImageFilelist;
	}
	
	private void retriveImageFromPath(String str, List<ImageData> list)
	{
		List<String> ImageList = new ArrayList<String>();
		util.FileOperator.RecurseFileToList(ESIData.DataManager.getImagePathList(), ESIData.DataManager.getImageSupportList(), ImageList);
		for(String str1 : ImageList)
		{
			ImageData data = new ImageData();
			data.setName(util.FileOperator.getFileName(str1).substring(0, util.FileOperator.getFileName(str1).lastIndexOf(".")));
			data.setPath(str1);
			list.add(data);
		}
	}
	
	private List<String> RetriveExcel()
	{
		System.out.println("��ʼ����Excel�б�");
		List<String> ExcelFilelist = new ArrayList<String>();
		//��ȡ����ͼƬ��·��
		util.FileOperator.RecurseFileToList(ESIData.DataManager.getExcelPathList(), ESIData.DataManager.getExcelSupportList(),ExcelFilelist);
		ESIUIManager.getMainWindow().getLblExcelFileNum().setText(Integer.toString(ExcelFilelist.size()));		
		System.out.println("Excel�б�������");
		return ExcelFilelist;
	}
	
	private void updateOverlCounterUI(int Counter, int NumOfElements)
	{
		float percentage =  (float) (((float)Counter) / ((float)NumOfElements) *100.00);
		try{
			EventQueue.invokeLater( new Runnable(){
				public void run() {
					try {
						ESIUIManager.getMainWindow().getLblOveralProcess().setText(Counter + "/" + NumOfElements);
						ESIUIManager.getMainWindow().UpdateOveralPrograssBar((int)percentage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			});
		}catch (Exception e){
			
		}
	}
	

	private void updateCurrentlCounterUI(int Counter, int NumOfElements)
	{
		float percentage =  (float) (((float)Counter) / ((float)NumOfElements) *100.00);
		try {
			EventQueue.invokeLater( new Runnable(){
					public void run() {
						try {
							ESIUIManager.getMainWindow().getLblCurrentProcess().setText(Counter + "/" + NumOfElements);
							ESIUIManager.getMainWindow().UpdateCurrentPrograssBar((int)percentage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}

	

}
