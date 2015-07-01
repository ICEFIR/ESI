package ESIData;

import ESI.ESIProperties;
import ui.ESIUIManager;
import util.UIDataOperator;

public class SettingOperator extends ESIData{

	public static void LoadSettingsFromUI()
	{
		System.out.print("储存配置...");
		loadImagePathsListFromUI();
		loadExcelPathListFromUI();
		loadSearchKeyListsFromUI();
		loadExcelImagePositionKeyListsFromUI();
		loadExcelExclusiveExceptionListFromUI();
		loadSearchBoundaryFromUI();
		loadImageSizeFromUI();
		loadCellPropertyFromUI();
		ESIProperties.SaveAll();

		System.out.println("完成");
	}
	
	private static void loadImagePathsListFromUI()
	{
		//从UI加载列表
		ExcelImagePathList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistImagePath());
	}
	
	private static void loadExcelPathListFromUI()
	{
		//从UI加载列表,储存在ExcelFileList中
		ExcelPathList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistExcelPath());
	}
	private static void loadSearchKeyListsFromUI()
	{

		//从UI加载列表
		ExcelSearchKeyList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistSearchKey());
	}
	private static void loadExcelExclusiveExceptionListFromUI()
	{
		//从UI加载列表
		ExcelExclusiveExceptionList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistExclusiveExceptionList());
	}
	private static void loadExcelImagePositionKeyListsFromUI()
	{
		//从UI加载列表
		ExcelImagePhraseKeyList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistImageKey());
	}
	
	private static void loadImageSizeFromUI()
	{
		imagesize.setWidth(ESIUIManager.getConfigWindow().getTxtImgWidth().getText());
		imagesize.setHeight(ESIUIManager.getConfigWindow().getTxtImgHeight().getText());
	}
	
	private static void loadSearchBoundaryFromUI()
	{
		searchboundary.setColIndex(ESIUIManager.getConfigWindow().getTxtKeyColEnd().getText());
		searchboundary.setRowIndex(ESIUIManager.getConfigWindow().getTxtKeyRowEnd().getText());
	}
	private static void loadCellPropertyFromUI()
	{
		cellproperty.setCellHeightExcelUnit(Float.parseFloat(ESIUIManager.getConfigWindow().getTxtCellHeightExcelUnit().getText()));
		cellproperty.setCellWidthExcelUnit(Float.parseFloat(ESIUIManager.getConfigWindow().getTxtCellWidthExcelUnit().getText()));
	}
	
	
}
