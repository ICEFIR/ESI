package ui;

public class ESIUIManager {
	protected static UIMain uiMainWindow;
	protected static UIConfig uiConfigWindow;
	//本组件用于管理所有窗体
	
	//取得已实例化的主窗体
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
