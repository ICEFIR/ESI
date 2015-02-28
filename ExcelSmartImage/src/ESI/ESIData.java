package ESI;

import java.util.ArrayList;
import java.util.List;

import ESIObjects.ImageData;
import ESIObjects.ImageSize;
import ESIObjects.SearchBoundary;

public class ESIData {
	//�����ʼ��ʱ���ص�����
	protected static List<String> ImageSupportList = new ArrayList<String>();
	//�������ݺ�����չ
	//protected static List<String> ExcelPathList = new ArrayList<String>();
		
	//���ü������UI���ص�����
	protected static List<String> ImagePathList = new ArrayList<String>();
	protected static List<String> ExcelFileList = new ArrayList<String>();
	protected static List<String> ExcelSearchKeyList= new ArrayList<String>();
	protected static List<String> ExcelImagePositionKeyList = new ArrayList<String>();
	protected static SearchBoundary searchboundary = new SearchBoundary();
	protected static ImageSize imagesize = new ImageSize();
	
	
	//��Excelִ������ص�����
	protected static List<ImageData> Imagelist = new ArrayList<ImageData>();
}
