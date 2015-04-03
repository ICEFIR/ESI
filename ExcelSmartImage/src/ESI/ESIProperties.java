package ESI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ESIData.ESISerialize;


public class ESIProperties {
	public static void SaveAll()
	{
		try {
			ESISerialize seriallize = new ESISerialize();
			FileOutputStream fos = new FileOutputStream(ESIData.DataManager.getSettingFile());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(seriallize);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ReadAll()
	{
		try {
		FileInputStream fin= new FileInputStream (ESIData.DataManager.getSettingFile());
		ObjectInputStream ois = new ObjectInputStream(fin);
			ESISerialize seriallize= (ESISerialize) ois.readObject();
			ESIData.DataManager.RetriveDataFromFiles(seriallize);
		fin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
