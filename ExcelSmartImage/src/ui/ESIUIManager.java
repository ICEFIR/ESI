package ui;

public class ESIUIManager {
	protected static UIMain uiMainWindow;
	protected static UIConfig uiConfigWindow;
	//��������ڹ������д���
	
	//ȡ����ʵ������������
	public static UIMain getMainWindow()
	{
		return uiMainWindow;
	}
	public static UIConfig getConfigWindow()
	{
		return uiConfigWindow;
	}
	public static void printInfo(String str)
	{
		uiMainWindow.getPrimeStatu().setText(str);
	}
	public static void printInfo(int Num) {
		// TODO Auto-generated method stub
		printInfo(Integer.toString(Num));
	}
}
