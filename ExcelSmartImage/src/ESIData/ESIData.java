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
	//程序初始化时加载的设置
	protected static List<String> ImageSupportList = new ArrayList<String>();
	protected static List<String> ExcelSupportList = new ArrayList<String>();
	//下行内容后续扩展
	//protected static List<String> ExcelPathList = new ArrayList<String>();
	
	//配置加载类从UI加载的设置
	protected static List<String> ExcelImagePathList = new ArrayList<String>();
	protected static List<String> ExcelPathList = new ArrayList<String>();
	protected static List<String> ExcelSearchKeyList= new ArrayList<String>();
	protected static List<String> ExcelImagePhraseKeyList = new ArrayList<String>(); //图片列表关键词
	protected static List<String> ExcelExclusiveExceptionList = new ArrayList<String>();
	protected static SearchBoundary searchboundary = new SearchBoundary();
	protected static ImageSize imagesize = new ImageSize();

}
