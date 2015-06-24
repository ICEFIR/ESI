import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ESI.ESIProperties;
import ESIData.DataManager;
import ui.UILoader;

public class ESIM {
	//Excel Smart Image Main

	public  static void main(String[] arg)
	{
		System.out.println("Initiating");

		//初始化
		SystemInitialise();
		//显示主窗体
		LoadESIConfig();
		UILoader.loadMainWindow(null);
		//UIManager.getMainWindow().show();
	}
	private static void SystemInitialise()
	{
		LoadImageSupportList();
		LoadExcelSupportList();
		
		//确认配置文件
		//可能需要改用Bean
		File file = new File(ESIData.DataManager.getSettingFile()); 
		System.out.println(file.getAbsolutePath());
		File parent = file.getParentFile();
		if(!parent.exists() && !parent.mkdirs()){
		    throw new IllegalStateException("Couldn't create dir: " + parent);
		}
		if (!file.exists())
		{
			try {
				file.createNewFile();
				ESIProperties.SaveAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			ESIProperties.ReadAll();
		}
	}
	private static void LoadESIConfig()
	{
		//配置UI
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	private static void LoadImageSupportList()
	{
		DataManager.getImageSupportList().add("jpg");
		DataManager.getImageSupportList().add("png");
		DataManager.getImageSupportList().add("jpeg");
		DataManager.getImageSupportList().add("bmp");
	}
	private static void LoadExcelSupportList()
	{
		DataManager.getExcelSupportList().add("xls");
		DataManager.getExcelSupportList().add("xlsx");
	}
	
}
