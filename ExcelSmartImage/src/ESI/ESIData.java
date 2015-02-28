package ESI;

import java.util.ArrayList;
import java.util.List;

import ESIObjects.ImageData;
import ESIObjects.ImageSize;
import ESIObjects.SearchBoundary;

public class ESIData {
	//程序初始化时加载的设置
	protected static List<String> ImageSupportList = new ArrayList<String>();
	//下行内容后续扩展
	//protected static List<String> ExcelPathList = new ArrayList<String>();
		
	//配置加载类从UI加载的设置
	protected static List<String> ImagePathList = new ArrayList<String>();
	protected static List<String> ExcelFileList = new ArrayList<String>();
	protected static List<String> ExcelSearchKeyList= new ArrayList<String>();
	protected static List<String> ExcelImagePositionKeyList = new ArrayList<String>();
	protected static SearchBoundary searchboundary = new SearchBoundary();
	protected static ImageSize imagesize = new ImageSize();
	
	
	//由Excel执行类加载的配置
	protected static List<ImageData> Imagelist = new ArrayList<ImageData>();
}
