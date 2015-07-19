package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOperator {
	//����һ�����Զ�ѡ�ļ����ļ��еĶԻ��򣬷���һ��String

	private static String current_path = "";

	
	public static File[] SelectExcelFileOrDirectionary()
	{
		File currentFile;
		try{
			currentFile = new File (current_path);
		}catch (Exception e){
			current_path = "";
			currentFile = new File (current_path);
		}
		
		JFileChooser JFChooser =new JFileChooser(currentFile);

		FileNameExtensionFilter filter= new FileNameExtensionFilter("Excel �ļ�","xls","xlsx");
		
		JFChooser.setDialogTitle("��Excel�ļ����ļ���");
		JFChooser.setMultiSelectionEnabled(true);
		JFChooser.addChoosableFileFilter(filter);
		JFChooser.setAcceptAllFileFilterUsed(true);
		JFChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		JFChooser.showDialog(null, "ѡ��");
		current_path = JFChooser.getCurrentDirectory().toString();
		File[] file = JFChooser.getSelectedFiles();
		return file;
	}
	
	public static void addFilesAbsolutePathToList(List<String> list, File[] file)
	{
		if (file.length==0) return;
		for (int i = 0; i < file.length; i ++)
		{
			list.add(file[i].getAbsolutePath());
		}
	}
	public static void addFilesAbsolutePathToList(DefaultListModel<String> list, File[] file)
	{
		if (file.length==0) return;
		for (int i = 0; i < file.length; i ++)
		{
			list.addElement((file[i].getAbsolutePath()));
		}
	}
	
	
	
	//��ȡ�����ļ�
	
	//�÷���RecurseFileToList(Pathlist, {"jpg","png"},outputlist)
	
	public static void  RecurseFileToList(DefaultListModel<String> getlistExcelPath, String[] typestrs,List<String> excelFileList) {
		
		RecurseFileToList(UIDataOperator.ConvertDefaultListModeltoList(getlistExcelPath),typestrs,excelFileList);
	}
	public static void  RecurseFileToList(DefaultListModel<String> getlistExcelPath, List<String> typelist,List<String> excelFileList) {
		
		RecurseFileToList(UIDataOperator.ConvertDefaultListModeltoList(getlistExcelPath),typelist,excelFileList);
	}
	public static void RecurseFileToList(String path, String[] typestrs,List<String> outputlist) 
	{
		List<String> typelist = new ArrayList<String>();
		
		for(String str:typestrs)
		{
			typelist.add(str);
		}
		RecurseFileToList(path,typelist, outputlist);
	}
	
	public static void RecurseFileToList(List<String> pathlist,String[] typestrs,List<String> outputlist) 
	{
		List<String> typelist = new ArrayList<String>();
		
		for(String str:typestrs)
		{
			typelist.add(str);
		}
		RecurseFileToList(pathlist,typelist, outputlist);
	}
	
	public static void RecurseFileToList(List<String> pathlist,List<String> typelist,List<String> outputlist) 
	{
		for(String str:pathlist)
		{
			RecurseFileToList(str,typelist, outputlist);
		}
		
	}
	
	public static void RecurseFileToList(String path,List<String> typelist,List<String> outputlist) 
	//���������ļ��У�����ͼƬ����ӵ��б�
	{
		if(!checkExist(path)) return;
		File file = new File(path);
		if(file.isFile())
		{
			  AddValidFile(file,typelist,outputlist);
			  return;
		}
		
		File[] files = file.listFiles();
		
		for (File fl : files)
		{
			  if (fl.isDirectory())
			  {
				  //���������ļ������ļ��е�
				  RecurseFileToList(fl.getAbsolutePath(),typelist,outputlist);  
			  }
			  else
			  {
				  //�ж��Ƿ������ļ�����
				  AddValidFile(fl,typelist,outputlist);
			  }
		}
	}
	public static void AddValidFile(File fl,List<String> typelist,List<String> outputlist)
	{
		  for (String str:typelist)
		  {
			   if (fl.getName().toLowerCase().endsWith(str))
			   {
				   outputlist.add(fl.getAbsolutePath());
			   } 
		  }
	}
	public static File[] SelectFolder()
	{
		File currentFile;
		try{
			currentFile = new File (current_path);
		}catch (Exception e){
			current_path = "";
			currentFile = new File (current_path);
		}
		JFileChooser JFChooser =new JFileChooser(currentFile);
		JFChooser.setDialogTitle("�ļ���");
		JFChooser.setMultiSelectionEnabled(true);
		JFChooser.setAcceptAllFileFilterUsed(true);
		JFChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		JFChooser.showDialog(null, "ѡ��");
		current_path = JFChooser.getCurrentDirectory().toString();
		File[] file = JFChooser.getSelectedFiles();
		return file;
	}
	public static boolean checkExist(String path)
	{
		File file = new File(path);
		if (file.exists()) return true;
		return false;
	}
	public static boolean checkIsFile(String path)
	{
		File file = new File(path);
		if (!file.exists()) return false;
		if (file.isFile()) return true;
		return false;
	}
	public static String getFileName(String str)
	{
		File f = new File(str);
		return f.getName();
	}
	
}
