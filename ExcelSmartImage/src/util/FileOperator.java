package util;

import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOperator {
	//����һ�����Զ�ѡ�ļ����ļ��еĶԻ��򣬷���һ��String
	public static File[] SelectExcelFileOrDirectionary()
	{
		File currentFile = new File ("");
		JFileChooser JFChooser =new JFileChooser(currentFile);

		FileNameExtensionFilter filter= new FileNameExtensionFilter("Excel �ļ�","xls","xlsx");
		
		JFChooser.setDialogTitle("��Excel�ļ����ļ���");
		JFChooser.setMultiSelectionEnabled(true);
		JFChooser.addChoosableFileFilter(filter);
		JFChooser.setAcceptAllFileFilterUsed(true);
		JFChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		JFChooser.showDialog(null, "ѡ��");
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
	
	
	public static File[] SelectFolder()
	{
		File currentFile = new File ("");
		JFileChooser JFChooser =new JFileChooser(currentFile);
		JFChooser.setDialogTitle("�ļ���");
		JFChooser.setMultiSelectionEnabled(true);
		JFChooser.setAcceptAllFileFilterUsed(true);
		JFChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		JFChooser.showDialog(null, "ѡ��");
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
}
