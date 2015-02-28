package util;

import java.awt.Point;
import java.awt.Toolkit;

public class UIDimention {

	public static int getScreenHeight()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	public static int getScreenWidth()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
	public static int getCenterHorizontal(int Width)
	{
		return ((getScreenWidth() - Width)/2);
	}
	public static int getCenterVertical(int Height)
	{
		return ((getScreenHeight() - Height)/2);
	}
	
	//获取屏幕中心点
	public static Point getCenterPoint()
	{
		Point p = new Point();
		p.setLocation((getScreenWidth()/2),(getScreenHeight()/2));
		return p;
	}
	
	//获取目标高宽并计算出目标居中点
	public static Point getCenterPoint(int x, int y)
	{
		Point p = new Point();
		p.setLocation(getCenterHorizontal(x), getCenterVertical(y));
		return p;
	}
}
