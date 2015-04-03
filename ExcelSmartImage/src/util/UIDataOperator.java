package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class UIDataOperator {
	public static void ConvertDefaultListModeltoList(DefaultListModel<String> defaultlistmodel,List<String> list)
	{
		try{
			for (int i = 0; i < defaultlistmodel.size();i++)
			{
				list.add(defaultlistmodel.get(i));
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public static List<String> ConvertDefaultListModeltoList(DefaultListModel<String> defaultlistmodel)
	{
		List<String> list = new ArrayList<String>();
		try{
			for (int i = 0; i < defaultlistmodel.size();i++)
			{
				list.add(defaultlistmodel.get(i));
			}
			return list;
		}catch (Exception e)
		{
			System.out.println(e);
			return list;
		}
	}
	public static void ConvertListToDefaultListModel(List<String> list,DefaultListModel<String> Defaultlist)
	{
		try{
			for (int i = 0; i < list.size();i++)
			{
				Defaultlist.addElement((list.get(i)));
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	public static DefaultListModel<String> ConvertListToDefaultListModel(List<String> list)
	{
		DefaultListModel<String> Defaultlist = new DefaultListModel<String>();
		try{
			for (int i = 0; i < list.size();i++)
			{
				Defaultlist.addElement((list.get(i)));
			}
			return Defaultlist;
		}catch (Exception e)
		{
			System.out.println(e);
			return Defaultlist;
		}
		
	}
	
	
	
}
