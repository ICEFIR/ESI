package ESIData;

import java.util.List;

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
	
	public static List<ImageData> getImageList()
	{
		return Imagelist;
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

	public static ImageSize getImageSize()
	{
		return imagesize;
	}
	
	//For other uses
	public static List<String> getExcelFileList()
	{
		return ExcelFileList;
	}
	
	public static String SearchImageList(String Name)
	{
		//����·����null
		for (ImageData imagedata : Imagelist)
		{
			if (imagedata.getName().equals(Name))
			{
				return imagedata.getPath();
			}
		}
		return null;
	}
}