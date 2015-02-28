package ui;

import javax.swing.JFrame;

import util.FileOperator;
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

import java.awt.Window.Type;

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
	private JPanel SearchKeySetting;
	private JList<String> SearchKeyList;
	private JButton BtnDeleteSearchKey;
	private JButton btnAddSearchKey;
	private JButton btnAddImageKey;
	private JButton BtnDeleteImageKey;
	private JList<String> ImageKeyList;
	private JPanel ImageKeySetting;
	private JTextField txtImgHeight;
	private JTextField txtImgWidth;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtKeyStart;
	private JTextField txtKeyEnd;
	private JSeparator separator_3;
	private JTextField txtGaped;
	private JSeparator separator_4;
	private JList<String> ExcelPathList;
	
	//映射列表
	private DefaultListModel<String> listImagePath;
	private DefaultListModel<String> listExcelPath;
	private DefaultListModel<String> listSearchKey;
	private DefaultListModel<String> listImageKey;
	

	
	
	
	/**
	 * Launch the application.
	 */
	public void show() {
		
		frame.setLocation(UIDimention.getCenterPoint(frame.getWidth(), frame.getHeight()));
		frame.setVisible(true);
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
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 521, 496);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, separator, 64, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, separator, 72, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(separator);
		
		label = new JLabel("\u66F4\u6539\u914D\u7F6E");
		springLayout.putConstraint(SpringLayout.SOUTH, label, -5, SpringLayout.NORTH, separator);
		springLayout.putConstraint(SpringLayout.EAST, label, -189, SpringLayout.EAST, frame.getContentPane());
		label.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
		frame.getContentPane().add(label);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 28, SpringLayout.SOUTH, separator);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 9, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 346, SpringLayout.SOUTH, separator);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -7, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(tabbedPane);
		
		
		//Excel路径目录
		ExcelPathSetting = new JPanel();
		tabbedPane.addTab("Excel\u8DEF\u5F84\u76EE\u5F55", null, ExcelPathSetting, null);
		SpringLayout sl_ExcelPathSetting = new SpringLayout();
		ExcelPathSetting.setLayout(sl_ExcelPathSetting);
		
		JScrollPane ScrollPaneExcel = new JScrollPane();
		sl_ExcelPathSetting.putConstraint(SpringLayout.NORTH, ScrollPaneExcel, 0, SpringLayout.NORTH, ExcelPathSetting);
		sl_ExcelPathSetting.putConstraint(SpringLayout.WEST, ScrollPaneExcel, 0, SpringLayout.WEST, ExcelPathSetting);
		sl_ExcelPathSetting.putConstraint(SpringLayout.EAST, ScrollPaneExcel, 0, SpringLayout.EAST, ExcelPathSetting);
		ExcelPathSetting.add(ScrollPaneExcel);
		
		
		listExcelPath = new DefaultListModel<String>();
		ExcelPathList = new JList<String>(listExcelPath);
		
		
		btnAddExcelPath = new JButton("\u6DFB\u52A0Excel\u6587\u4EF6\u6216\u8DEF\u5F84");
		sl_ExcelPathSetting.putConstraint(SpringLayout.SOUTH, ScrollPaneExcel, 0, SpringLayout.NORTH, btnAddExcelPath);
		btnAddExcelPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileOperator.addFilesAbsolutePathToList(listExcelPath, FileOperator.SelectExcelFileOrDirectionary());
				
			}
		});
		sl_ExcelPathSetting.putConstraint(SpringLayout.WEST, btnAddExcelPath, 0, SpringLayout.WEST, ExcelPathSetting);
		sl_ExcelPathSetting.putConstraint(SpringLayout.EAST, btnAddExcelPath, -240, SpringLayout.EAST, ExcelPathSetting);
		sl_ExcelPathSetting.putConstraint(SpringLayout.SOUTH, btnAddExcelPath, 0, SpringLayout.SOUTH, ExcelPathSetting);
		ExcelPathSetting.add(btnAddExcelPath);
		
		JButton BtnDeleteExcelPath = new JButton("\u5220\u9664\u9009\u4E2D\u5185\u5BB9");
		BtnDeleteExcelPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ExcelPathList.isSelectionEmpty())listExcelPath.removeRange(ExcelPathList.getMinSelectionIndex(), ExcelPathList.getMaxSelectionIndex());
			}
		});
		sl_ExcelPathSetting.putConstraint(SpringLayout.NORTH, BtnDeleteExcelPath, 0, SpringLayout.SOUTH, ScrollPaneExcel);
		sl_ExcelPathSetting.putConstraint(SpringLayout.WEST, BtnDeleteExcelPath, 1, SpringLayout.EAST, btnAddExcelPath);
		sl_ExcelPathSetting.putConstraint(SpringLayout.SOUTH, BtnDeleteExcelPath, 0, SpringLayout.SOUTH, btnAddExcelPath);
		sl_ExcelPathSetting.putConstraint(SpringLayout.EAST, BtnDeleteExcelPath, 0, SpringLayout.EAST, ScrollPaneExcel);
		
		
		ScrollPaneExcel.setViewportView(ExcelPathList);
		ExcelPathSetting.add(BtnDeleteExcelPath);
		
		
		//图片路径目录
		ImagePathSetting = new JPanel();
		tabbedPane.addTab("\u56FE\u7247\u8DEF\u5F84\u76EE\u5F55", null, ImagePathSetting, null);
		SpringLayout sl_ImagePathSetting = new SpringLayout();
		ImagePathSetting.setLayout(sl_ImagePathSetting);
		
		JScrollPane ScrollPaneImage = new JScrollPane();
		sl_ImagePathSetting.putConstraint(SpringLayout.NORTH, ScrollPaneImage, 0, SpringLayout.NORTH, ImagePathSetting);
		sl_ImagePathSetting.putConstraint(SpringLayout.WEST, ScrollPaneImage, 0, SpringLayout.WEST, ImagePathSetting);
		sl_ImagePathSetting.putConstraint(SpringLayout.EAST, ScrollPaneImage, 0, SpringLayout.EAST, ImagePathSetting);
		ImagePathSetting.add(ScrollPaneImage);
		
		listImagePath = new DefaultListModel<String>();
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
		
		//
		
		
		//图片名称列关键词目录
		SearchKeySetting = new JPanel();
		tabbedPane.addTab("\u5546\u54C1\u7F16\u53F7\u5217\u5173\u952E\u8BCD", null, SearchKeySetting, null);
		SpringLayout sl_SearchKeySetting = new SpringLayout();
		SearchKeySetting.setLayout(sl_SearchKeySetting);
		
		JScrollPane ScrollPaneSearchKey = new JScrollPane();
		sl_SearchKeySetting.putConstraint(SpringLayout.NORTH, ScrollPaneSearchKey, 0, SpringLayout.NORTH, SearchKeySetting);
		sl_SearchKeySetting.putConstraint(SpringLayout.WEST, ScrollPaneSearchKey, 0, SpringLayout.WEST, SearchKeySetting);
		sl_SearchKeySetting.putConstraint(SpringLayout.EAST, ScrollPaneSearchKey, 0, SpringLayout.EAST, SearchKeySetting);
		SearchKeySetting.add(ScrollPaneSearchKey);
		
		listSearchKey = new DefaultListModel<String>();
		SearchKeyList = new JList<String>(listSearchKey);
		ScrollPaneSearchKey.setViewportView(SearchKeyList);
		
		BtnDeleteSearchKey = new JButton("\u5220\u9664\u5173\u952E\u8BCD");
		BtnDeleteSearchKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!SearchKeyList.isSelectionEmpty())listSearchKey.removeRange(SearchKeyList.getMinSelectionIndex(), SearchKeyList.getMaxSelectionIndex());
			}
		});
		sl_SearchKeySetting.putConstraint(SpringLayout.SOUTH, ScrollPaneSearchKey, 0, SpringLayout.NORTH, BtnDeleteSearchKey);
		sl_SearchKeySetting.putConstraint(SpringLayout.SOUTH, BtnDeleteSearchKey, 0, SpringLayout.SOUTH, SearchKeySetting);
		sl_SearchKeySetting.putConstraint(SpringLayout.EAST, BtnDeleteSearchKey, 0, SpringLayout.EAST, SearchKeySetting);
		SearchKeySetting.add(BtnDeleteSearchKey);
		
		btnAddSearchKey = new JButton("\u6DFB\u52A0\u5173\u952E\u8BCD");
		btnAddSearchKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = JOptionPane.showInputDialog("请输入想添加的关键词");
				if (!(string==null)&&!string.isEmpty())listSearchKey.addElement(string);
				
			}
		});
		sl_SearchKeySetting.putConstraint(SpringLayout.WEST, btnAddSearchKey, 0, SpringLayout.WEST, SearchKeySetting);
		sl_SearchKeySetting.putConstraint(SpringLayout.EAST, btnAddSearchKey, -240, SpringLayout.EAST, SearchKeySetting);
		sl_SearchKeySetting.putConstraint(SpringLayout.WEST, BtnDeleteSearchKey, 1, SpringLayout.EAST, btnAddSearchKey);
		sl_SearchKeySetting.putConstraint(SpringLayout.SOUTH, btnAddSearchKey, 0, SpringLayout.SOUTH, SearchKeySetting);
		SearchKeySetting.add(btnAddSearchKey);
		//
		
		//图片插入列关键词目录
		ImageKeySetting = new JPanel();
		tabbedPane.addTab("\u56FE\u7247\u63D2\u5165\u5217\u5173\u952E\u8BCD", null, ImageKeySetting, null);
		SpringLayout sl_ImageKeySetting = new SpringLayout();
		ImageKeySetting.setLayout(sl_ImageKeySetting);
		
		JScrollPane ScrollPaneImageKey = new JScrollPane();
		sl_ImageKeySetting.putConstraint(SpringLayout.NORTH, ScrollPaneImageKey, 0, SpringLayout.NORTH, ImageKeySetting);
		sl_ImageKeySetting.putConstraint(SpringLayout.WEST, ScrollPaneImageKey, 0, SpringLayout.WEST, ImageKeySetting);
		sl_ImageKeySetting.putConstraint(SpringLayout.EAST, ScrollPaneImageKey, 0, SpringLayout.EAST, ImageKeySetting);
		ImageKeySetting.add(ScrollPaneImageKey);
		
		listImageKey = new DefaultListModel<String>();
		ImageKeyList = new JList<String>(listImageKey);
		ScrollPaneImageKey.setViewportView(ImageKeyList);
		
		BtnDeleteImageKey = new JButton("\u5220\u9664\u5173\u952E\u8BCD");
		BtnDeleteImageKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ImageKeyList.isSelectionEmpty())listImageKey.removeRange(ImageKeyList.getMinSelectionIndex(), ImageKeyList.getMaxSelectionIndex());
			}
		});
		sl_ImageKeySetting.putConstraint(SpringLayout.SOUTH, ScrollPaneImageKey, 0, SpringLayout.NORTH, BtnDeleteImageKey);
		sl_ImageKeySetting.putConstraint(SpringLayout.SOUTH, BtnDeleteImageKey, 0, SpringLayout.SOUTH, ImageKeySetting);
		sl_ImageKeySetting.putConstraint(SpringLayout.EAST, BtnDeleteImageKey, 0, SpringLayout.EAST, ImageKeySetting);
		ImageKeySetting.add(BtnDeleteImageKey);
		
		btnAddImageKey = new JButton("\u6DFB\u52A0\u5173\u952E\u8BCD");
		btnAddImageKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = JOptionPane.showInputDialog("请输入想添加的关键词");
				if (!(string==null)&&!string.isEmpty())listImageKey.addElement(string);
			}
		});
		sl_ImageKeySetting.putConstraint(SpringLayout.WEST, btnAddImageKey, 0, SpringLayout.WEST, ImageKeySetting);
		sl_ImageKeySetting.putConstraint(SpringLayout.EAST, btnAddImageKey, -240, SpringLayout.EAST, ImageKeySetting);
		sl_ImageKeySetting.putConstraint(SpringLayout.WEST, BtnDeleteImageKey, 1, SpringLayout.EAST, btnAddImageKey);
		sl_ImageKeySetting.putConstraint(SpringLayout.SOUTH, btnAddImageKey, 0, SpringLayout.SOUTH, ImageKeySetting);
		ImageKeySetting.add(btnAddImageKey);
		
		
		// 
		JPanel OtherSettings = new JPanel();
		tabbedPane.addTab("\u5176\u4ED6\u914D\u7F6E", null, OtherSettings, null);
		SpringLayout sl_OtherSettings = new SpringLayout();
		OtherSettings.setLayout(sl_OtherSettings);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u7247\u9AD8\u5EA6");
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, lblNewLabel, 28, SpringLayout.NORTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, lblNewLabel, 8, SpringLayout.WEST, OtherSettings);
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		OtherSettings.add(lblNewLabel);
		
		txtImgHeight = new JTextField();
		txtImgHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validation.ValidateToInt(txtImgHeight);
			}
		});
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtImgHeight, 30, SpringLayout.NORTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, txtImgHeight, 158, SpringLayout.WEST, OtherSettings);
		OtherSettings.add(txtImgHeight);
		txtImgHeight.setColumns(1);
		
		JLabel label_1 = new JLabel("\u56FE\u7247\u5BBD\u5EA6");
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_1, 30, SpringLayout.NORTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, label_1, 238, SpringLayout.WEST, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, txtImgHeight, -6, SpringLayout.WEST, label_1);
		label_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		OtherSettings.add(label_1);
		
		txtImgWidth = new JTextField();
		txtImgWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validation.ValidateToInt(txtImgWidth);
			}
		});
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtImgWidth, 30, SpringLayout.NORTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, txtImgWidth, -22, SpringLayout.EAST, OtherSettings);
		txtImgWidth.setColumns(1);
		OtherSettings.add(txtImgWidth);
		
		separator_1 = new JSeparator();
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_1, 18, SpringLayout.NORTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_1, 0, SpringLayout.WEST, lblNewLabel);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblNewLabel);
		OtherSettings.add(separator_1);
		
		separator_2 = new JSeparator();
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, txtImgWidth, -4, SpringLayout.NORTH, separator_2);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, txtImgHeight, -6, SpringLayout.NORTH, separator_2);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, separator_2);
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_2, 55, SpringLayout.NORTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_2, 8, SpringLayout.WEST, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_2, -232, SpringLayout.SOUTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_2, -10, SpringLayout.EAST, OtherSettings);
		OtherSettings.add(separator_2);
		
		label_2 = new JLabel("\u5173\u952E\u8BCD\u5B9A\u4F4D\u7EC8\u6B62\u884C");
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_2, 7, SpringLayout.SOUTH, separator_2);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, lblNewLabel);
		label_2.setFont(new Font("SimSun", Font.PLAIN, 18));
		OtherSettings.add(label_2);
		
		label_3 = new JLabel("\u5173\u952E\u8BCD\u5B9A\u4F4D\u7EC8\u6B62\u5217");
		sl_OtherSettings.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label_1);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, label_3, 0, SpringLayout.SOUTH, label_2);
		label_3.setFont(new Font("SimSun", Font.PLAIN, 18));
		OtherSettings.add(label_3);
		
		txtKeyStart = new JTextField();
		txtKeyStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validation.ValidateToInt(txtKeyStart);
			}
		});
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtKeyStart, 7, SpringLayout.SOUTH, separator_2);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, txtKeyStart, 6, SpringLayout.EAST, label_2);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, txtKeyStart, 0, SpringLayout.SOUTH, label_2);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, txtKeyStart, -6, SpringLayout.WEST, label_3);
		OtherSettings.add(txtKeyStart);
		txtKeyStart.setColumns(1);
		
		txtKeyEnd = new JTextField();
		txtKeyEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validation.ValidateToInt(txtKeyEnd);
			}
		});
		sl_OtherSettings.putConstraint(SpringLayout.WEST, txtImgWidth, 0, SpringLayout.WEST, txtKeyEnd);
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtKeyEnd, 7, SpringLayout.SOUTH, separator_2);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, txtKeyEnd, 6, SpringLayout.EAST, label_3);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, txtKeyEnd, 0, SpringLayout.SOUTH, label_2);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, txtKeyEnd, -22, SpringLayout.EAST, OtherSettings);
		txtKeyEnd.setColumns(1);
		OtherSettings.add(txtKeyEnd);
		
		separator_3 = new JSeparator();
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_3, 6, SpringLayout.SOUTH, label_2);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_3, 8, SpringLayout.WEST, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_3, 10, SpringLayout.SOUTH, label_2);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_3, 474, SpringLayout.WEST, OtherSettings);
		OtherSettings.add(separator_3);
		
		JLabel label_4 = new JLabel("\u6267\u884C\u95F4\u9694\u884C\u6570");
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, label_4, 4, SpringLayout.SOUTH, separator_3);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, label_4, 0, SpringLayout.WEST, lblNewLabel);
		label_4.setFont(new Font("SimSun", Font.PLAIN, 18));
		OtherSettings.add(label_4);
		
		txtGaped = new JTextField();
		txtGaped.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Validation.ValidateToInt(txtGaped);
			}
		});
	
		
	
		
		
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, txtGaped, 0, SpringLayout.NORTH, label_4);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, txtGaped, 0, SpringLayout.WEST, txtImgHeight);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, txtGaped, 0, SpringLayout.EAST, txtImgHeight);
		txtGaped.setColumns(1);
		OtherSettings.add(txtGaped);
		
		separator_4 = new JSeparator();
		sl_OtherSettings.putConstraint(SpringLayout.NORTH, separator_4, 6, SpringLayout.SOUTH, label_4);
		sl_OtherSettings.putConstraint(SpringLayout.WEST, separator_4, 0, SpringLayout.WEST, lblNewLabel);
		sl_OtherSettings.putConstraint(SpringLayout.SOUTH, separator_4, -159, SpringLayout.SOUTH, OtherSettings);
		sl_OtherSettings.putConstraint(SpringLayout.EAST, separator_4, 0, SpringLayout.EAST, separator_1);
		OtherSettings.add(separator_4);
		//


		
	}
}
