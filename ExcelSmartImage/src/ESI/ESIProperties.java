package ESI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ui.ESIUIManager;
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
			setMainUI();
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
	
	public static void setMainUI()
	{
		ESIUIManager.getMainWindow().getLblExcelPathNum().setText(Integer.toString(ESIData.DataManager.getExcelPathList().size()));
		ESIUIManager.getMainWindow().getLblImagePathNum().setText(Integer.toString(ESIData.DataManager.getImagePathList().size()));
		ESIUIManager.getMainWindow().getLblExcelFileNum().setText("Unknown");
		ESIUIManager.getMainWindow().getLblImageFileNum().setText("Unknown");
		ESIUIManager.getMainWindow().getLblOveralProcess().setText("Unknown");
		ESIUIManager.getMainWindow().getLblCurrentProcess().setText("Unknown");
		ESIUIManager.getMainWindow().getOveralProcessBar().setValue(0);
		ESIUIManager.getMainWindow().getCurrentProcessBar().setValue(0);
	}
}
