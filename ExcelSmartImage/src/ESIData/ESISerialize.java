package ESIData;

import java.io.Serializable;
import java.util.List;

import ESIObjects.ImageSize;
import ESIObjects.SearchBoundary;

public class ESISerialize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  List<String> listImagePath = DataManager.getImagePathList();
	public  List<String> listExcelPath = DataManager.getExcelPathList();
	public  List<String> listSearchKey = DataManager.getExcelSearchKeyList();
	public  List<String> listImageKey = DataManager.getExcelImageKeyPhraseList(); //Í¼Æ¬ÁÐ±í¹Ø¼ü´Ê
	public  List<String> listExclusiveExceptionList = DataManager.getExcelExclusiveExceptionList();
	public  SearchBoundary SerialisedSearchboundary = DataManager.getSearchBoundary();;
	public  ImageSize SerialisedImagesize = DataManager.getImageSize();;
	

}
