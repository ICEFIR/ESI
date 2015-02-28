package ui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ESI.ExcelManger;
import util.UIDimention;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class UIMain {

	private JFrame frmExcelSmartImage;
	private JTextField txtExcel;
	private JButton btnStart;
	private JButton btnNewButton;
	private JTextField txtImagePath;
	private DefaultListModel<String> ListKeysList;
	private JList<String> listKey;
	private JTextField txtPrimeStatu;
	private JTextField txtSecondaryStatu = new JTextField();
	/**
	 * Launch the application.
	 */
	public void show() {
		frmExcelSmartImage.setLocation(UIDimention.getCenterPoint(frmExcelSmartImage.getWidth(), frmExcelSmartImage.getHeight()));;
		
		frmExcelSmartImage.setVisible(true);
		
	}
	/**
	 * Create the application.
	 */
	
	public UIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExcelSmartImage = new JFrame();
		frmExcelSmartImage.setTitle("Excel Smart Image");
		frmExcelSmartImage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				System.exit(0);
			}
		});
		frmExcelSmartImage.setBounds(100, 100, 547, 449);
		frmExcelSmartImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, txtSecondaryStatu, 0, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtSecondaryStatu, 0, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		frmExcelSmartImage.getContentPane().setLayout(springLayout);
		
		JButton btnSelExcelPath = new JButton("\u9009\u53D6EXCEL\u6587\u4EF6");
		
		frmExcelSmartImage.getContentPane().add(btnSelExcelPath);
		
		txtExcel = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtExcel, 12, SpringLayout.EAST, btnSelExcelPath);
		springLayout.putConstraint(SpringLayout.EAST, txtExcel, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnSelExcelPath, 0, SpringLayout.NORTH, txtExcel);
		springLayout.putConstraint(SpringLayout.NORTH, txtExcel, 40, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtExcel, 63, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		frmExcelSmartImage.getContentPane().add(txtExcel);
		txtExcel.setColumns(10);
		
		btnStart = new JButton("\u5F00\u59CB");
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 0, SpringLayout.WEST, txtExcel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnStart, -41, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnStart, 0, SpringLayout.EAST, txtExcel);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcelManger.Start();
			}
		});
		frmExcelSmartImage.getContentPane().add(btnStart);
		
		btnNewButton = new JButton("\u9009\u53D6\u56FE\u7247\u6587\u4EF6\u5939");
		springLayout.putConstraint(SpringLayout.WEST, btnSelExcelPath, 0, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnSelExcelPath, 0, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 69, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 127, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frmExcelSmartImage.getContentPane().add(btnNewButton);
		
		txtImagePath = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtImagePath, 6, SpringLayout.SOUTH, txtExcel);
		springLayout.putConstraint(SpringLayout.WEST, txtImagePath, 0, SpringLayout.WEST, txtExcel);
		springLayout.putConstraint(SpringLayout.SOUTH, txtImagePath, 29, SpringLayout.SOUTH, txtExcel);
		springLayout.putConstraint(SpringLayout.EAST, txtImagePath, 0, SpringLayout.EAST, txtExcel);
		frmExcelSmartImage.getContentPane().add(txtImagePath);
		txtImagePath.setColumns(10);
		
		
		JButton btnAddKey = new JButton("\u6DFB\u52A0\u5173\u952E\u5B57");
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnAddKey, 20, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnAddKey, 0, SpringLayout.WEST, btnSelExcelPath);
		springLayout.putConstraint(SpringLayout.EAST, btnAddKey, 0, SpringLayout.EAST, btnSelExcelPath);
		frmExcelSmartImage.getContentPane().add(btnAddKey);
		
		JButton btnDeleteKey = new JButton("\u5220\u9664\u9009\u4E2D\u5173\u952E\u5B57");
		btnDeleteKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					ListKeysList.remove(listKey.getSelectedIndex());
				}catch (Exception e)
				{
					System.out.println(e);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteKey, 6, SpringLayout.SOUTH, btnAddKey);
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteKey, 0, SpringLayout.WEST, btnSelExcelPath);
		springLayout.putConstraint(SpringLayout.EAST, btnDeleteKey, 0, SpringLayout.EAST, btnSelExcelPath);
		frmExcelSmartImage.getContentPane().add(btnDeleteKey);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, -6, SpringLayout.NORTH, btnSelExcelPath);
		springLayout.putConstraint(SpringLayout.EAST, menuBar, 0, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		frmExcelSmartImage.getContentPane().add(menuBar);
		
		JMenu mnConfig = new JMenu("\u8BBE\u7F6E");
		menuBar.add(mnConfig);
		
		JMenuItem menuItem = new JMenuItem("\u66F4\u6539\u914D\u7F6E");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				UILoader.loadConfigWindow(null);
			}
		});
		mnConfig.add(menuItem);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 11, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 22, SpringLayout.SOUTH, txtImagePath);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -86, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, txtExcel);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, txtExcel);
		frmExcelSmartImage.getContentPane().add(scrollPane);

		ListKeysList = new DefaultListModel<String>();
		listKey = new JList<String>(ListKeysList);
		listKey.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(listKey);
		
		txtPrimeStatu = new JTextField();
		txtPrimeStatu.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, txtSecondaryStatu, 0, SpringLayout.NORTH, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.EAST, txtSecondaryStatu, 0, SpringLayout.WEST, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.WEST, txtPrimeStatu, 91, SpringLayout.WEST, menuBar);
		txtPrimeStatu.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtPrimeStatu, 18, SpringLayout.SOUTH, btnStart);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPrimeStatu, 0, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtPrimeStatu, 0, SpringLayout.EAST, menuBar);
		frmExcelSmartImage.getContentPane().add(txtPrimeStatu);
		txtPrimeStatu.setColumns(10);
		txtSecondaryStatu.setEditable(false);
		frmExcelSmartImage.getContentPane().add(txtSecondaryStatu);
		txtSecondaryStatu.setColumns(10);
		
	}
	
	public JList<String> getListKeys() {
		
		return listKey;
	}
	public DefaultListModel<String> getListKeyList() {
		
		return ListKeysList;
	}
	public JTextField getTxtExcel() {
		return txtExcel;
	}
	public JTextField getTxtImagePath() {
		return txtImagePath;
	}
	public JTextField getTxtPrimeStatu() {
		return txtPrimeStatu;
	}
	public JTextField getTxtSecondaryStatu() {
		return txtSecondaryStatu;
	}
	
}
