package ESIData;

import java.util.List;

import ESIObjects.CellProperty;
import ESIObjects.ImageData;
import ESIObjects.ImageSize;
import ESIObjects.SearchBoundary;

public class DataManager extends ESIData {

	public static String getSettingFile()
	{
		return settingFile;
	}
	public static List<String> getImagePathList()
	{
		return ExcelImagePathList;
	}
	public static List<String> getImageSupportList()
	{
		return ImageSupportList;
	}
	public static List<String> getExcelSupportList()
	{
		return ExcelSupportList;
	}
	public static List<String> getExcelSearchKeyList()
	{
		return ExcelSearchKeyList;
	}
	public static SearchBoundary getSearchBoundary()
	{
		return searchboundary;
	}
	public static List<String> getExcelImageKeyPhraseList()
	{
		return ExcelImagePhraseKeyList;
	}
	
	public static List<String> getExcelExclusiveExceptionList()
	{
		return ExcelExclusiveExceptionList;
	}
	public static List<String> getExcelPathList()
	{
		return ExcelPathList;
	}
	public static CellProperty getCellProperty()
	{
		return cellproperty;
	}
	public static ImageSize getImageSize()
	{
		return imagesize;
	}
	
	public static String SearchImageList(String Name, List<ImageData> ImageFilelist)
	{
		//·µ»ØÂ·¾¶»ònull
		for (ImageData imagedata : ImageFilelist)
		{
			if (imagedata.getName().equals(Name))
			{
				return imagedata.getPath();
			}
		}
		return null;
	}
	
	
	public static void RetriveDataFromFiles(ESISerialize data)
	{
		ExcelImagePathList = data.listImagePath;
		ExcelPathList = data.listExcelPath;
		ExcelSearchKeyList = data.listSearchKey;
		ExcelImagePhraseKeyList = data.listImageKey;
		ExcelExclusiveExceptionList = data.listExclusiveExceptionList;
		searchboundary = data.SerialisedSearchboundary;
		imagesize = data.SerialisedImagesize;
		cellproperty = data.cellproperty;
	}

}
