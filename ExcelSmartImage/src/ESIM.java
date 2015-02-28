import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ESI.DataManager;
import ui.UILoader;

public class ESIM {
	//Excel Smart Image Main

	public  static void main(String[] arg)
	{
		//��ʼ��
		SystemInitialise();
		//��ʾ������
		LoadESIConfig();
		UILoader.loadMainWindow(null);
		//UIManager.getMainWindow().show();
	}
	private static void SystemInitialise()
	{
		LoadImageSupportList();
		
		
		
		//ȷ�������ļ�
		File file = new File("config.properties");
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
		//����UI
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