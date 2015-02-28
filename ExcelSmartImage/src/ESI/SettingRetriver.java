package ESI;

import ui.ESIUIManager;
import util.UIDataOperator;

public class SettingRetriver extends ESIData{

	public static void LoadSettingFromUI()
	{
		System.out.println("��ʼ��������");
		loadImagePaths();
		loadExcelFileLists();
		loadSearchKeyLists();
		loadExcelImagePositionKeyLists();
		loadSearchBoundary();
		loadImageSize();
		LoadGapeLineNum();
		System.out.println("���");
	}
	
	private static void loadImagePaths()
	{
		//��ʼ���б�
		ImagePathList.clear();
		//��UI�����б�
		ImagePathList.add(ESIUIManager.getMainWindow().getTxtImagePath().getText());
		
	}
	private static void loadExcelFileLists()
	{
		//��ʼ���б�
		ExcelFileList.clear();
		//��UI�����б�
		ExcelFileList.add(ESIUIManager.getMainWindow().getTxtExcel().getText());
	}
	private static void loadSearchKeyLists()
	{
		//��ʼ���ؼ����б�
		ExcelSearchKeyList.clear();
		//��UI�����б�
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
		//��ʼ���ؼ����б�
		ExcelImagePositionKeyList.clear();
		//��UI�����б�
		ExcelImagePositionKeyList.add("ͼƬ");
	}
	
	private static void LoadGapeLineNum()
	{
		
	}
}
