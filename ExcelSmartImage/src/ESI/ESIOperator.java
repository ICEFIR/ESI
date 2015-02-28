package ESI;

import ui.ESIUIManager;
import util.ModuleOperator;

public class  ESIOperator implements ModuleOperator {
	//实现与ExcelSmartImage的接口类
	protected static void printInfo(String str)
	{
		 ESIUIManager.printInfo(str);
	}
	
	
}
