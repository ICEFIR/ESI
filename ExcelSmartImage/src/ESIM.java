import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		
		
		//确认配置文件
		//可能需要改用Bean
		File file = new File(ESIData.DataManager.getSettingFile()); 
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	
}
