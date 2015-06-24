package ESIData;

import java.util.ArrayList;
import java.util.List;
import ESIObjects.ImageSize;
import ESIObjects.SearchBoundary;

public class ESIData {
	/**
	 * 
	 */
	protected static final String settingFile = "Settings/config.settings";
	//�����ʼ��ʱ���ص�����
	protected static List<String> ImageSupportList = new ArrayList<String>();
	protected static List<String> ExcelSupportList = new ArrayList<String>();
	//�������ݺ�����չ
	//protected static List<String> ExcelPathList = new ArrayList<String>();
	
	//���ü������UI���ص�����
	protected static List<String> ExcelImagePathList = new ArrayList<String>();
	protected static List<String> ExcelPathList = new ArrayList<String>();
	protected static List<String> ExcelSearchKeyList= new ArrayList<String>();
	protected static List<String> ExcelImagePhraseKeyList = new ArrayList<String>(); //ͼƬ�б�ؼ���
	protected static List<String> ExcelExclusiveExceptionList = new ArrayList<String>();
	protected static SearchBoundary searchboundary = new SearchBoundary();
	protected static ImageSize imagesize = new ImageSize();

}
