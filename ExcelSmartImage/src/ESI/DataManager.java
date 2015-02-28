package ESI;

import java.util.List;

import ESIObjects.ImageData;
import ESIObjects.ImageSize;
import ESIObjects.SearchBoundary;

public class DataManager extends ESIData {

	
	public static List<String> getImagePathList()
	{
		return ImagePathList;
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
	public static List<String> getExcelImagePositionKeyList()
	{
		return ExcelImagePositionKeyList;
	}
	public static List<String> getExcelFileList()
	{
		return ExcelFileList;
	}
	public static ImageSize getImageSize()
	{
		return imagesize;
	}
	
	public static String SearchImageList(String Name)
	{
		//·µ»ØÂ·¾¶»ònull
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
