package ESIData;

import ESI.ESIProperties;
import ui.ESIUIManager;
import util.UIDataOperator;

public class SettingOperator extends ESIData{

	public static void LoadSettingsFromUI()
	{
		System.out.print("��������...");
		loadImagePathsListFromUI();
		loadExcelPathListFromUI();
		loadSearchKeyListsFromUI();
		loadExcelImagePositionKeyListsFromUI();
		loadExcelExclusiveExceptionListFromUI();
		loadSearchBoundaryFromUI();
		loadImageSizeFromUI();
		loadCellPropertyFromUI();
		ESIProperties.SaveAll();

		System.out.println("���");
	}
	
	private static void loadImagePathsListFromUI()
	{
		//��UI�����б�
		ExcelImagePathList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistImagePath());
	}
	
	private static void loadExcelPathListFromUI()
	{
		//��UI�����б�,������ExcelFileList��
		ExcelPathList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistExcelPath());
	}
	private static void loadSearchKeyListsFromUI()
	{

		//��UI�����б�
		ExcelSearchKeyList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistSearchKey());
	}
	private static void loadExcelExclusiveExceptionListFromUI()
	{
		//��UI�����б�
		ExcelExclusiveExceptionList = UIDataOperator.ConvertDefaultListModeltoList(ESIUIManager.getConfigWindow().getlistExclusiveExceptionList());
	}
	private static void loadExcelImagePositionKeyListsFromUI()
	{
		//��UI�����б�
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
