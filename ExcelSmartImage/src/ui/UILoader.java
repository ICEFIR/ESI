package ui;

import java.awt.EventQueue;

public class UILoader extends ESIUIManager {
	//���������ʵ����������
	public static void loadMainWindow(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uiMainWindow = new UIMain();
					uiMainWindow.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	public static void loadConfigWindow(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uiConfigWindow = new UIConfig();
					uiConfigWindow.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
