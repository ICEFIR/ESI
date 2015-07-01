package ui;

import javax.swing.JFrame;

import util.FileOperator;
import util.UIDataOperator;
import util.UIDimention;
import util.Validation;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIConfig {

	private JFrame frame;
	private final JSeparator separator = new JSeparator();
	private JLabel label;
	private JTabbedPane tabbedPane;
	private JPanel ImagePathSetting;
	private JList<String> ImagePathList;
	private JButton BtnDeleteImagePath;
	private JButton btnAddImagePath;
	private JPanel ExcelPathSetting;
	private JButton btnAddExcelPath;
	private JPanel SearchKeySettings;
	private JList<String> SearchKeyList;
	private JButton BtnDeleteSearchKey;
	private JButton btnAddSearchKey;
	private JButton btnAddImageKey;
	private JButton BtnDeleteImageKey;
	private JList<String> ImageKeyList;
	private JPanel ImageKeySettings;
	private JTextField txtImgHeight;
	private JTextField txtImgWidth;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtKeyRowEnd;
	private JTextField txtKeyColEnd;
	private JSeparator separator_3;
	private JList<String> ExcelPathList;
	private JPanel ExceptionSettings;
	private JList<String> ExclusiveExceptionList;
	private JScrollPane ExcetionListKeys;
	private JButton btnSaveAll;
	private JButton btnCancel;


	
	//映射列表
	private DefaultListModel<String> listImagePath;
	private DefaultListModel<String> listExcelPath;
	private DefaultListModel<String> listSearchKey;
	private DefaultListModel<String> listImageKey;
	private DefaultListModel<String> listExclusiveExceptionList; //非处理例外列表
	private JLabel label_4;
	private JSeparator separator_4;
	private JLabel lblExcel;
	private JLabel label_6;
	private JTextField txtCellHeightExcelUnit;
	private JLabel label_7;
	private JTextField txtCellWidthExcelUnit;
	private JLabel lblExcel_1;
	private JSeparator separator_5;

	public DefaultListModel<String> getlistImagePath()
	{
		return listImagePath;
	}
	
	public  DefaultListModel<String> getlistExcelPath()
	{
		return listExcelPath;
	}
	public  DefaultListModel<String> getlistSearchKey()
	{
		return listSearchKey;
	}
	public  DefaultListModel<String> getlistImageKey()
	{
		return listImageKey;
	}
	public  DefaultListModel<String> getlistExclusiveExceptionList()
	{
		return listExclusiveExceptionList;
	}
	/**
	 * Launch the application.
	 */
	
	
	public void show() {
		
		frame.setLocation(UIDimention.getCenterPoint(frame.getWidth(), frame.getHeight()));
		frame.setVisible(true);
	}

	private void PreSettings()
	{
		listImagePath = UIDataOperator.ConvertListToDefaultListModel(ESIData.DataManager.getImagePathList());
		listExcelPath = UIDataOperator.ConvertListToDefaultListModel(ESIData.DataManager.getExcelPathList());
		listSearchKey =	UIDataOperator.ConvertListToDefaultListModel(ESIData.DataManager.getExcelSearchKeyList());
		listImageKey = UIDataOperator.ConvertListToDefaultListModel(ESIData.DataManager.getExcelImageKeyPhraseList());
		listExclusiveExceptionList = UIDataOperator.ConvertListToDefaultListModel(ESIData.DataManager.getExcelExclusiveExceptionList());

	}
	private void PostSettings()
	{
		txtKeyRowEnd.setText(String.valueOf(ESIData.DataManager.getSearchBoundary().getRowIndex()));
		txtKeyColEnd.setText(String.valueOf(ESIData.DataManager.getSearchBoundary().getColIndex()));
		txtImgHeight.setText(String.valueOf(ESIData.DataManager.getImageSize().getHeight()));
		txtImgWidth.setText(String.valueOf(ESIData.DataManager.getImageSize().getWidth()));
		txtCellHeightExcelUnit.setText(String.valueOf(ESIData.DataManager.getCellProperty().getCellHeightExcelUnit()));
		txtCellWidthExcelUnit.setText(String.valueOf(ESIData.DataManager.getCellProperty().getCellWidthExcelUnit()));
	}
	/**
	 * Create the application.
	 */
	public UIConfig() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		PreSettings();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 605, 550);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, separator, 64, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, separator, 72, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(separator);
		
		label = new JLabel("\u66F4\u6539\u914D\u7F6E");
		springLayout.putConstraint(SpringLayout.WEST, label, 226, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, separator);
		label.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
		frame.getContentPane().add(label);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 6, SpringLayout.SOUTH, separator);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 392, SpringLayout.SOUTH, separator);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -10, SpringLayout.EAST, separator);
		frame.getContentPane().add(tabbedPane);

		//Excel路径目录
		/*********************************************************************************************************************************************************************/
			ExcelPathSetting = new JPanel();
			tabbedPane.addTab("Excel\u8DEF\u5F84\u76EE\u5F55", null, ExcelPathSetting, null);
			SpringLayout sl_ExcelPathSetting = new SpringLayout();
			ExcelPathSetting.setLayout(sl_ExcelPathSetting);
			btnAddExcelPath = new JButton("\u6DFB\u52A0Excel\u6587\u4EF6\u6216\u8DEF\u5F84");
			btnAddExcelPath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileOperator.addFilesAbsolutePathToList(listExcelPath, FileOperator.SelectExcelFileOrDirectionary());
				}
			});
			
			JScrollPane ScrollPaneExcel = new JScrollPane();
			sl_ExcelPathSetting.putConstraint(SpringLayout.NORTH, ScrollPaneExcel, 0, SpringLayout.NORTH, ExcelPathSetting);
			sl_ExcelPathSetting.putConstraint(SpringLayout.WEST, ScrollPaneExcel, 0, SpringLayout.WEST, ExcelPathSetting);
			sl_ExcelPathSetting.putConstraint(SpringLayout.SOUTH, ScrollPaneExcel, 0, SpringLayout.NORTH, btnAddExcelPath);
			sl_ExcelPathSetting.putConstraint(SpringLayout.EAST, ScrollPaneExcel, 0, SpringLayout.EAST, ExcelPathSetting);
			ExcelPathSetting.add(ScrollPaneExcel);

			ExcelPathList = new JList<String>(listExcelPath);
			ScrollPaneExcel.setViewportView(ExcelPathList);
			sl_ExcelPathSetting.putConstraint(SpringLayout.WEST, btnAddExcelPath, 0, SpringLayout.WEST, ExcelPathSetting);
			sl_ExcelPathSetting.putConstraint(SpringLayout.EAST, btnAddExcelPath, -240, SpringLayout.EAST, ExcelPathSetting);
			sl_ExcelPathSetting.putConstraint(SpringLayout.SOUTH, btnAddExcelPath, 0, SpringLayout.SOUTH, ExcelPathSetting);
			ExcelPathSetting.add(btnAddExcelPath);
			
			JButton BtnDeleteExcelPath = new JButton("\u5220\u9664\u9009\u4E2D\u5185\u5BB9");
			sl_ExcelPathSetting.putConstraint(SpringLayout.NORTH, BtnDeleteExcelPath, 0, SpringLayout.SOUTH, ScrollPaneExcel);
			sl_ExcelPathSetting.putConstraint(SpringLayout.EAST, BtnDeleteExcelPath, 0, SpringLayout.EAST, ScrollPaneExcel);
			BtnDeleteExcelPath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					util.UIDataOperator.DeleteSelectedValueFromList(ExcelPathList,listExcelPath);

				}
			});
			sl_ExcelPathSetting.putConstraint(SpringLayout.WEST, BtnDeleteExcelPath, 1, SpringLayout.EAST, btnAddExcelPath);
			sl_ExcelPathSetting.putConstraint(SpringLayout.SOUTH, BtnDeleteExcelPath, 0, SpringLayout.SOUTH, btnAddExcelPath);
			ExcelPathSetting.add(BtnDeleteExcelPath);
		/*********************************************************************************************************************************************************************/
		
		//图片路径目录
		/*********************************************************************************************************************************************************************/
			ImagePathSetting = new JPanel();
			tabbedPane.addTab("\u56FE\u7247\u8DEF\u5F84\u76EE\u5F55", null, ImagePathSetting, null);
			SpringLayout sl_ImagePathSetting = new SpringLayout();
			ImagePathSetting.setLayout(sl_ImagePathSetting);
			
			JScrollPane ScrollPaneImage = new JScrollPane();
			sl_ImagePathSetting.putConstraint(SpringLayout.NORTH, ScrollPaneImage, 0, SpringLayout.NORTH, ImagePathSetting);
			sl_ImagePathSetting.putConstraint(SpringLayout.WEST, ScrollPaneImage, 0, SpringLayout.WEST, ImagePathSetting);
			sl_ImagePathSetting.putConstraint(SpringLayout.EAST, ScrollPaneImage, 0, SpringLayout.EAST, ImagePathSetting);
			ImagePathSetting.add(ScrollPaneImage);
			
			ImagePathList = new JList<String>(listImagePath);
			ScrollPaneImage.setViewportView(ImagePathList);
			
			BtnDeleteImagePath = new JButton("\u5220\u9664\u9009\u4E2D\u5185\u5BB9");
			BtnDeleteImagePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!ImagePathList.isSelectionEmpty())listImagePath.removeRange(ImagePathList.getMinSelectionIndex(), ImagePathList.getMaxSelectionIndex());
				}
			});
			sl_ImagePathSetting.putConstraint(SpringLayout.SOUTH, ScrollPaneImage, 0, SpringLayout.NORTH, BtnDeleteImagePath);
			sl_ImagePathSetting.putConstraint(SpringLayout.SOUTH, BtnDeleteImagePath, 0, SpringLayout.SOUTH, ImagePathSetting);
			sl_ImagePathSetting.putConstraint(SpringLayout.EAST, BtnDeleteImagePath, 0, SpringLayout.EAST, ImagePathSetting);
			ImagePathSetting.add(BtnDeleteImagePath);
			
			btnAddImagePath = new JButton("\u6DFB\u52A0\u56FE\u7247\u5E93\u8DEF\u5F84");
			btnAddImagePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileOperator.addFilesAbsolutePathToList(listImagePath, FileOperator.SelectFolder());
				}
			});
			
			sl_ImagePathSetting.putConstraint(SpringLayout.WEST, btnAddImagePath, 0, SpringLayout.WEST, ImagePathSetting);
			sl_ImagePathSetting.putConstraint(SpringLayout.EAST, btnAddImagePath, -240, SpringLayout.EAST, ImagePathSetting);
			sl_ImagePathSetting.putConstraint(SpringLayout.WEST, BtnDeleteImagePath, 1, SpringLayout.EAST, btnAddImagePath);
			sl_ImagePathSetting.putConstraint(SpringLayout.SOUTH, btnAddImagePath, 0, SpringLayout.SOUTH, ImagePathSetting);
			ImagePathSetting.add(btnAddImagePath);
		
		/*********************************************************************************************************************************************************************/
		
		
		//图片名称列关键词目录
			SearchKeySettings = new JPanel();
			tabbedPane.addTab("\u5546\u54C1\u7F16\u53F7\u5217\u5173\u952E\u8BCD", null, SearchKeySettings, null);
			SpringLayout sl_SearchKeySettings = new SpringLayout();
			SearchKeySettings.setLayout(sl_SearchKeySettings);
			
			JScrollPane ScrollPaneSearchKey = new JScrollPane();
			sl_SearchKeySettings.putConstraint(SpringLayout.NORTH, ScrollPaneSearchKey, 0, SpringLayout.NORTH, SearchKeySettings);
			sl_SearchKeySettings.putConstraint(SpringLayout.WEST, ScrollPaneSearchKey, 0, SpringLayout.WEST, SearchKeySettings);
			sl_SearchKeySettings.putConstraint(SpringLayout.EAST, ScrollPaneSearchKey, 0, SpringLayout.EAST, SearchKeySettings);
			SearchKeySettings.add(ScrollPaneSearchKey);
			
			SearchKeyList = new JList<String>(listSearchKey);
			ScrollPaneSearchKey.setViewportView(SearchKeyList);
			
			BtnDeleteSearchKey = new JButton("\u5220\u9664\u5173\u952E\u8BCD");
			BtnDeleteSearchKey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!SearchKeyList.isSelectionEmpty())listSearchKey.removeRange(SearchKeyList.getMinSelectionIndex(), SearchKeyList.getMaxSelectionIndex());
				}
			});
			sl_SearchKeySettings.putConstraint(SpringLayout.SOUTH, ScrollPaneSearchKey, 0, SpringLayout.NORTH, BtnDeleteSearchKey);
			sl_SearchKeySettings.putConstraint(SpringLayout.SOUTH, BtnDeleteSearchKey, 0, SpringLayout.SOUTH, SearchKeySettings);
			sl_SearchKeySettings.putConstraint(SpringLayout.EAST, BtnDeleteSearchKey, 0, SpringLayout.EAST, SearchKeySettings);
			SearchKeySettings.add(BtnDeleteSearchKey);
			
			btnAddSearchKey = new JButton("\u6DFB\u52A0\u5173\u952E\u8BCD");
			btnAddSearchKey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String string = JOptionPane.showInputDialog("请输入想添加的关键词");
					if (!(string==null)&&!string.isEmpty())listSearchKey.addElement(string);
					
				}
			});
			sl_SearchKeySettings.putConstraint(SpringLayout.WEST, btnAddSearchKey, 0, SpringLayout.WEST, SearchKeySettings);
			sl_SearchKeySettings.putConstraint(SpringLayout.EAST, btnAddSearchKey, -240, SpringLayout.EAST, SearchKeySettings);
			sl_SearchKeySettings.putConstraint(SpringLayout.WEST, BtnDeleteSearchKey, 1, SpringLayout.EAST, btnAddSearchKey);
			sl_SearchKeySettings.putConstraint(SpringLayout.SOUTH, btnAddSearchKey, 0, SpringLayout.SOUTH, SearchKeySettings);
			SearchKeySettings.add(btnAddSearchKey);
		/*********************************************************************************************************************************************************************/
		
		//图片插入列关键词目录
		/*********************************************************************************************************************************************************************/
			ImageKeySettings = new JPanel();
			tabbedPane.addTab("\u56FE\u7247\u63D2\u5165\u5217\u5173\u952E\u8BCD", null, ImageKeySettings, null);
			SpringLayout sl_ImageKeySettings = new SpringLayout();
			ImageKeySettings.setLayout(sl_ImageKeySettings);
			
			JScrollPane ScrollPaneImageKey = new JScrollPane();
			sl_ImageKeySettings.putConstraint(SpringLayout.NORTH, ScrollPaneImageKey, 0, SpringLayout.NORTH, ImageKeySettings);
			sl_ImageKeySettings.putConstraint(SpringLayout.WEST, ScrollPaneImageKey, 0, SpringLayout.WEST, ImageKeySettings);
			sl_ImageKeySettings.putConstraint(SpringLayout.EAST, ScrollPaneImageKey, 0, SpringLayout.EAST, ImageKeySettings);
			ImageKeySettings.add(ScrollPaneImageKey);
			
			ImageKeyList = new JList<String>(listImageKey);
			ScrollPaneImageKey.setViewportView(ImageKeyList);
			
			BtnDeleteImageKey = new JButton("\u5220\u9664\u5173\u952E\u8BCD");
			BtnDeleteImageKey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!ImageKeyList.isSelectionEmpty())listImageKey.removeRange(ImageKeyList.getMinSelectionIndex(), ImageKeyList.getMaxSelectionIndex());
				}
			});
			sl_ImageKeySettings.putConstraint(SpringLayout.SOUTH, ScrollPaneImageKey, 0, SpringLayout.NORTH, BtnDeleteImageKey);
			sl_ImageKeySettings.putConstraint(SpringLayout.SOUTH, BtnDeleteImageKey, 0, SpringLayout.SOUTH, ImageKeySettings);
			sl_ImageKeySettings.putConstraint(SpringLayout.EAST, BtnDeleteImageKey, 0, SpringLayout.EAST, ImageKeySettings);
			ImageKeySettings.add(BtnDeleteImageKey);
			
			btnAddImageKey = new JButton("\u6DFB\u52A0\u5173\u952E\u8BCD");
			btnAddImageKey.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String string = JOptionPane.showInputDialog("请输入想添加的关键词");
					if (!(string==null)&&!string.isEmpty())listImageKey.addElement(string);
				}
			});
			sl_ImageKeySettings.putConstraint(SpringLayout.WEST, btnAddImageKey, 0, SpringLayout.WEST, ImageKeySettings);
			sl_ImageKeySettings.putConstraint(SpringLayout.EAST, btnAddImageKey, -240, SpringLayout.EAST, ImageKeySettings);
			sl_ImageKeySettings.putConstraint(SpringLayout.WEST, BtnDeleteImageKey, 1, SpringLayout.EAST, btnAddImageKey);
			sl_ImageKeySettings.putConstraint(SpringLayout.SOUTH, btnAddImageKey, 0, SpringLayout.SOUTH, ImageKeySettings);
			ImageKeySettings.add(btnAddImageKey);
		/*********************************************************************************************************************************************************************/
			
		//例外列表界面
		/*********************************************************************************************************************************************************************/
			ExceptionSettings = new JPanel();
			tabbedPane.addTab("\u4F8B\u5916\u5217\u8868", null, ExceptionSettings, "\u5982\u679C\u5546\u54C1\u7F16\u53F7\u5355\u5143\u683C\u5185\u5BB9\u7B49\u4E8E\u6B64\u5217\u8868\u4E2D\u4EFB\u610F\u4E00\u4E2A\u503C\uFF0C\u5219\u4E0D\u4F1A\u5BF9\u6B64\u6761\u8FDB\u884C\u4EFB\u4F55\u5904\u7406");
			SpringLayout sl_ExceptionSettings = new SpringLayout();
			ExceptionSettings.setLayout(sl_ExceptionSettings);
			
			JButton AddKeyExceptionList = new JButton("\u6DFB\u52A0\u5173\u952E\u8BCD");
			AddKeyExceptionList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String string = JOptionPane.showInputDialog("请输入想添加的关键词");
					if (!(string==null)&&!string.isEmpty())listExclusiveExceptionList.addElement(string);
				}
			});
			sl_ExceptionSettings.putConstraint(SpringLayout.WEST, AddKeyExceptionList, 0, SpringLayout.WEST, ExceptionSettings);
			sl_ExceptionSettings.putConstraint(SpringLayout.SOUTH, AddKeyExceptionList, 0, SpringLayout.SOUTH, ExceptionSettings);
			sl_ExceptionSettings.putConstraint(SpringLayout.EAST, AddKeyExceptionList, -240, SpringLayout.EAST, ExceptionSettings);
			ExceptionSettings.add(AddKeyExceptionList);
			
			JButton DelKeyExceptionList = new JButton("\u5220\u9664\u5173\u952E\u8BCD");
			DelKeyExceptionList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!ExclusiveExceptionList.isSelectionEmpty())listExclusiveExceptionList.removeRange(ExclusiveExceptionList.getMinSelectionIndex(), ExclusiveExceptionList.getMaxSelectionIndex());
				}
			});
			sl_ExceptionSettings.putConstraint(SpringLayout.WEST, DelKeyExceptionList, 325, SpringLayout.WEST, ExceptionSettings);
			sl_ExceptionSettings.putConstraint(SpringLayout.SOUTH, DelKeyExceptionList, 0, SpringLayout.SOUTH, ExceptionSettings);
			sl_ExceptionSettings.putConstraint(SpringLayout.EAST, DelKeyExceptionList, 0, SpringLayout.EAST, ExceptionSettings);
			ExceptionSettings.add(DelKeyExceptionList);
			
			ExcetionListKeys = new JScrollPane();
			sl_ExceptionSettings.putConstraint(SpringLayout.NORTH, ExcetionListKeys, 0, SpringLayout.NORTH, ExceptionSettings);
			sl_ExceptionSettings.putConstraint(SpringLayout.WEST, ExcetionListKeys, 0, SpringLayout.WEST, AddKeyExceptionList);
			sl_ExceptionSettings.putConstraint(SpringLayout.SOUTH, ExcetionListKeys, 0, SpringLayout.NORTH, AddKeyExceptionList);
			sl_ExceptionSettings.putConstraint(SpringLayout.EAST, ExcetionListKeys, 0, SpringLayout.EAST, DelKeyExceptionList);
			ExceptionSettings.add(ExcetionListKeys);
			
			ExclusiveExceptionList = new JList<String>(listExclusiveExceptionList);
			ExcetionListKeys.setViewportView(ExclusiveExceptionList);
		/*********************************************************************************************************************************************************************/
		
		//其他设置
		/*********************************************************************************************************************************************************************/
			
			btnSaveAll = new JButton("\u4FDD\u5B58");
			btnSaveAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ESIData.SettingOperator.LoadSettingsFromUI();
					frame.dispose();
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, btnSaveAll, 10, SpringLayout.SOUTH, tabbedPane);
			springLayout.putConstraint(SpringLayout.WEST, btnSaveAll, 0, SpringLayout.WEST, tabbedPane);
			springLayout.putConstraint(SpringLayout.SOUTH, btnSaveAll, -10, SpringLayout.SOUTH, frame.getContentPane());
			springLayout.putConstraint(SpringLayout.EAST, btnSaveAll, 335, SpringLayout.WEST, frame.getContentPane());
			frame.getContentPane().add(btnSaveAll);
			
			btnCancel = new JButton("\u53D6\u6D88");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(frame, "确认不保存直接退出？") == 0){
						frame.dispose();
					}
					
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 10, SpringLayout.SOUTH, tabbedPane);
			JPanel OtherSettings = new JPanel();
			tabbedPane.addTab("\u5176\u4ED6\u914D\u7F6E", null, OtherSettings, null);
			SpringLayout sl_OtherSettings = new SpringLayout();
			OtherSettings.setLayout(sl_OtherSettings);
			
			JLabel lblNewLabel = new JLabel("\u56FE\u7247\u9AD8\u5EA6");
			lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(lblNewLabel);
			
			txtImgHeight = new JTextField();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtImgHeight, 2, SpringLayout.NORTH, lblNewLabel);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, txtImgHeight, 78, SpringLayout.EAST, lblNewLabel);
			txtImgHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					Validation.ValidateToInt(txtImgHeight);
				}
			});
			OtherSettings.add(txtImgHeight);
			txtImgHeight.setColumns(1);
			
			JLabel label_1 = new JLabel("\u56FE\u7247\u5BBD\u5EA6");
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_1, 260, SpringLayout.WEST, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, txtImgHeight, -28, SpringLayout.WEST, label_1);
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblNewLabel);
			label_1.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_1);
			
			txtImgWidth = new JTextField();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtImgWidth, 2, SpringLayout.NORTH, lblNewLabel);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, txtImgWidth, 128, SpringLayout.EAST, label_1);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, txtImgWidth, -22, SpringLayout.EAST, OtherSettings);
			txtImgWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					Validation.ValidateToInt(txtImgWidth);
				}
			});
			txtImgWidth.setColumns(1);
			OtherSettings.add(txtImgWidth);
			
			separator_1 = new JSeparator();
			sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_1, 8, SpringLayout.WEST, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_1, -316, SpringLayout.SOUTH, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_1, -10, SpringLayout.EAST, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, separator_1);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, separator_1);
			OtherSettings.add(separator_1);
			
			separator_2 = new JSeparator();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_2, 51, SpringLayout.SOUTH, txtImgHeight);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_2, 8, SpringLayout.WEST, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_2, 0, SpringLayout.EAST, separator_1);
			OtherSettings.add(separator_2);
			
			label_2 = new JLabel("\u5173\u952E\u8BCD\u5B9A\u4F4D\u7EC8\u6B62\u884C");
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, lblNewLabel);
			label_2.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_2);
			
			label_3 = new JLabel("\u5173\u952E\u8BCD\u5B9A\u4F4D\u7EC8\u6B62\u5217");
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, label_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label_1);
			label_3.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_3);
			
			txtKeyRowEnd = new JTextField();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtKeyRowEnd, 0, SpringLayout.NORTH, label_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, txtKeyRowEnd, 0, SpringLayout.WEST, txtImgHeight);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, txtKeyRowEnd, -332, SpringLayout.EAST, OtherSettings);
			txtKeyRowEnd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					Validation.ValidateToInt(txtKeyRowEnd);
				}
			});
			OtherSettings.add(txtKeyRowEnd);
			txtKeyRowEnd.setColumns(1);
			
			txtKeyColEnd = new JTextField();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtKeyColEnd, 2, SpringLayout.NORTH, label_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, txtKeyColEnd, 0, SpringLayout.WEST, txtImgWidth);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, txtKeyColEnd, -22, SpringLayout.EAST, OtherSettings);
			txtKeyColEnd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					Validation.ValidateToInt(txtKeyColEnd);
				}
			});
			txtKeyColEnd.setColumns(1);
			OtherSettings.add(txtKeyColEnd);
			
			separator_3 = new JSeparator();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_2, 4, SpringLayout.SOUTH, separator_3);
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_3, -143, SpringLayout.SOUTH, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_3, 0, SpringLayout.WEST, lblNewLabel);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_3, 0, SpringLayout.EAST, separator_1);
			OtherSettings.add(separator_3);
			
			label_4 = new JLabel("");
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_2, 0, SpringLayout.SOUTH, label_4);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_4, 152, SpringLayout.WEST, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, label_4, -232, SpringLayout.SOUTH, OtherSettings);
			label_4.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_4);
			
			JLabel label_5 = new JLabel("\u56FE\u50CF\u5206\u8FA8\u7387\u914D\u7F6E\uFF08\u5355\u4F4D\uFF1A\u50CF\u7D20\uFF09");
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_5, 158, SpringLayout.WEST, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_1, 6, SpringLayout.SOUTH, label_5);
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_5, 10, SpringLayout.NORTH, OtherSettings);
			label_5.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_5);
			
			separator_4 = new JSeparator();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_4, 6, SpringLayout.SOUTH, lblNewLabel);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_4, 0, SpringLayout.WEST, lblNewLabel);
			OtherSettings.add(separator_4);
			
			lblExcel = new JLabel("Excel \u5355\u5143\u683C\u914D\u7F6E\uFF08\u5355\u4F4D\uFF1AExcel Unit\uFF09");
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, lblExcel, -6, SpringLayout.NORTH, separator_2);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, lblExcel, -113, SpringLayout.EAST, OtherSettings);
			lblExcel.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(lblExcel);
			
			label_6 = new JLabel("\u56FE\u7247\u5355\u5143\u683C\u9AD8\u5EA6");
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_6, 6, SpringLayout.SOUTH, separator_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_6, 0, SpringLayout.WEST, lblNewLabel);
			label_6.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_6);
			
			txtCellHeightExcelUnit = new JTextField();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtCellHeightExcelUnit, 6, SpringLayout.SOUTH, separator_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, txtCellHeightExcelUnit, 0, SpringLayout.WEST, txtImgHeight);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, txtCellHeightExcelUnit, 0, SpringLayout.EAST, txtImgHeight);
			txtCellHeightExcelUnit.setText("50");
			txtCellHeightExcelUnit.setColumns(1);
			OtherSettings.add(txtCellHeightExcelUnit);
			
			label_7 = new JLabel("\u56FE\u7247\u5355\u5143\u683C\u5BBD\u5EA6");
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_7, 6, SpringLayout.SOUTH, separator_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, label_7, 0, SpringLayout.WEST, label_1);
			label_7.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(label_7);
			
			txtCellWidthExcelUnit = new JTextField();
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtCellWidthExcelUnit, 6, SpringLayout.SOUTH, separator_2);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, txtCellWidthExcelUnit, 0, SpringLayout.WEST, txtImgWidth);
			sl_OtherSettings.putConstraint(SpringLayout.EAST, txtCellWidthExcelUnit, 0, SpringLayout.EAST, txtImgWidth);
			txtCellWidthExcelUnit.setText("8.4");
			txtCellWidthExcelUnit.setColumns(1);
			OtherSettings.add(txtCellWidthExcelUnit);
			
			lblExcel_1 = new JLabel("Excel \u626B\u63CF\u8BBE\u7F6E");
			sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_3, 6, SpringLayout.SOUTH, lblExcel_1);
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, lblExcel_1, -153, SpringLayout.SOUTH, OtherSettings);
			sl_OtherSettings.putConstraint(SpringLayout.WEST, lblExcel_1, 205, SpringLayout.WEST, OtherSettings);
			lblExcel_1.setFont(new Font("SimSun", Font.PLAIN, 18));
			OtherSettings.add(lblExcel_1);
			
			separator_5 = new JSeparator();
			sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_5, 0, SpringLayout.WEST, lblNewLabel);
			sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_5, -6, SpringLayout.NORTH, lblExcel);
			OtherSettings.add(separator_5);
			springLayout.putConstraint(SpringLayout.WEST, btnCancel, 0, SpringLayout.EAST, btnSaveAll);
			springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnSaveAll);
			springLayout.putConstraint(SpringLayout.EAST, btnCancel, -10, SpringLayout.EAST, frame.getContentPane());
			frame.getContentPane().add(btnCancel);
		/*********************************************************************************************************************************************************************/
			PostSettings();

		
	}
	public JTextField getTxtImgHeight() {
		return txtImgHeight;
	}
	public JTextField getTxtImgWidth() {
		return txtImgWidth;
	}
	public JTextField getTxtKeyRowEnd() {
		return txtKeyRowEnd;
	}
	public JTextField getTxtKeyColEnd() {
		return txtKeyColEnd;
	}
	public JTextField getTxtCellWidthExcelUnit() {
		return txtCellWidthExcelUnit;
	}
	public JTextField getTxtCellHeightExcelUnit() {
		return txtCellHeightExcelUnit;
	}
}
