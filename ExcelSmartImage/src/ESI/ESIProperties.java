package ESI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;


public class ESIProperties {
	public static void SaveAll() throws IOException
	{
		
	}
	
	public static void ReadAll() throws IOException
	{
		Properties settings = new Properties();
		FileOutputStream  out = new FileOutputStream (ESIData.DataManager.getSettingFile());
		settings.setProperty(key, value);
		settings.store(out,"---No Comment---");
		out.close();
	}
}
