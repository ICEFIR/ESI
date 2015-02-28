package ESIObjects;

public class ImageData {
	private String ImageName;
	private String ImagePath;
	public void setName(String name)
	{
		ImageName = name;
	}
	public void setPath(String path)
	{
		ImagePath = path;
	}
	
	public String getName()
	{
		return ImageName;
	}
	public String getPath()
	{
		return ImagePath;
	}
}
