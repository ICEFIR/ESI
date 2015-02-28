package ESI;

import ui.ESIUIManager;
import util.UIDataOperator;

public class SettingRetriver extends ESIData{

	public static void LoadSettingFromUI()
	{
		System.out.println("开始加载配置");
		loadImagePaths();
		loadExcelFileLists();
		loadSearchKeyLists();
		loadExcelImagePositionKeyLists();
		loadSearchBoundary();
		loadImageSize();
		LoadGapeLineNum();
		System.out.println("完成");
	}
	
	private static void loadImagePaths()
	{
		//初始化列表
		ImagePathList.clear();
		//从UI加载列表
		ImagePathList.add(ESIUIManager.getMainWindow().getTxtImagePath().getText());
		
	}
	private static void loadExcelFileLists()
	{
		//初始化列表
		ExcelFileList.clear();
		//从UI加载列表
		ExcelFileList.add(ESIUIManager.getMainWindow().getTxtExcel().getText());
	}
	private static void loadSearchKeyLists()
	{
		//初始化关键词列表
		ExcelSearchKeyList.clear();
		//从UI加载列表
		ExcelSearchKeyList = UIDataOperator.ConvertDefaultListModeltoList((ESIUIManager.getMainWindow().getListKeyList()));
	}
	private static void loadImageSize()
	{
		imagesize.setWidth(67);
		imagesize.setHeight(65);
	}
	private static void loadSearchBoundary()
	{
		searchboundary.setColIndex(40);
		searchboundary.setRowIndex(40);
	}
	private static void loadExcelImagePositionKeyLists()
	{
		//初始化关键词列表
		ExcelImagePositionKeyList.clear();
		//从UI加载列表
		ExcelImagePositionKeyList.add("图片");
	}
	
	private static void LoadGapeLineNum()
	{
		
	}
}
