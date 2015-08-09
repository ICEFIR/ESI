package ui;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ESI.ExcelManager;
import util.UIDimention;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants; 
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;

public class UIMain {

	private JFrame frmExcelSmartImage;
	private JButton btnStart;
	private JTextField txtPrimeStatu;
	private JTextField txtSecondaryStatu = new JTextField();
	private JButton btnChangeSetting;
	private JLabel lblExcel;
	private JLabel label;
	private JLabel lblExcel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JProgressBar CurrentProcessBar;
	private JProgressBar OveralProcessBar;
	private JLabel lblExcelPathNum;
	private JLabel lblImagePathNum;
	private JLabel lblExcelFileNum;
	private JLabel lblImageFileNum;
	private JLabel lblCurrentProcess;
	private JLabel lblOveralProcess;
	/**
	 * Launch the application.
	 */
	public void show() {
		frmExcelSmartImage.setLocation(UIDimention.getCenterPoint(frmExcelSmartImage.getWidth(), frmExcelSmartImage.getHeight()));;
		
		frmExcelSmartImage.setVisible(true);
		ESI.ESIProperties.setMainUI();
	}
	/**
	 * Create the application.
	 */
	
	public UIMain() {
		initialize();
	}
	
	private void post_initialize_process() {
		// TODO Auto-generated method stub
		
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
		springLayout.putConstraint(SpringLayout.EAST, txtSecondaryStatu, -456, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		frmExcelSmartImage.getContentPane().setLayout(springLayout);
		
		btnStart = new JButton("\u5F00\u59CB");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcelManager ESIP = new ExcelManager( "ESI Processor" );
				
				ESIP.start();
			}
		});
		frmExcelSmartImage.getContentPane().add(btnStart);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
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

		
		txtPrimeStatu = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPrimeStatu, -30, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnStart, -32, SpringLayout.NORTH, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.WEST, txtPrimeStatu, 0, SpringLayout.EAST, txtSecondaryStatu);
		springLayout.putConstraint(SpringLayout.EAST, txtPrimeStatu, 0, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		txtPrimeStatu.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, txtSecondaryStatu, 0, SpringLayout.NORTH, txtPrimeStatu);
		txtPrimeStatu.setEditable(false);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPrimeStatu, 0, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		frmExcelSmartImage.getContentPane().add(txtPrimeStatu);
		txtPrimeStatu.setColumns(10);
		txtSecondaryStatu.setEditable(false);
		frmExcelSmartImage.getContentPane().add(txtSecondaryStatu);
		txtSecondaryStatu.setColumns(10);
		
		btnChangeSetting = new JButton("\u66F4\u6539\u914D\u7F6E");
		springLayout.putConstraint(SpringLayout.SOUTH, btnChangeSetting, -106, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 6, SpringLayout.SOUTH, btnChangeSetting);
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 0, SpringLayout.WEST, btnChangeSetting);
		springLayout.putConstraint(SpringLayout.EAST, btnStart, 0, SpringLayout.EAST, btnChangeSetting);
		springLayout.putConstraint(SpringLayout.WEST, btnChangeSetting, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnChangeSetting, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		btnChangeSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UILoader.loadConfigWindow(null);
			}
		});
		frmExcelSmartImage.getContentPane().add(btnChangeSetting);
		
		lblExcel = new JLabel("Excel \u8868\u683C\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, lblExcel, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		lblExcel.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcel);
		
		label = new JLabel("\u56FE\u7247\u6587\u4EF6\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblExcel);
		label.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label);
		
		lblExcel_1 = new JLabel("Excel \u8DEF\u5F84\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, lblExcel, 11, SpringLayout.SOUTH, lblExcel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblExcel_1, 64, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblExcel_1, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		lblExcel_1.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcel_1);
		
		label_1 = new JLabel("\u56FE\u7247\u8DEF\u5F84\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblExcel_1);
		label_1.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label_1);
		
		label_2 = new JLabel("\u5F53\u524D\u8868\u683C\u5DF2\u5904\u7406\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 19, SpringLayout.SOUTH, lblExcel);
		springLayout.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, lblExcel);
		label_2.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u603B\u8FDB\u5EA6\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		label_3.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label_3);
		
		CurrentProcessBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, CurrentProcessBar, -195, SpringLayout.NORTH, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.WEST, CurrentProcessBar, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, CurrentProcessBar, -198, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, CurrentProcessBar, 0, SpringLayout.EAST, btnStart);
		frmExcelSmartImage.getContentPane().add(CurrentProcessBar);
		
		OveralProcessBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, btnChangeSetting, 22, SpringLayout.SOUTH, OveralProcessBar);
		springLayout.putConstraint(SpringLayout.NORTH, OveralProcessBar, 6, SpringLayout.SOUTH, CurrentProcessBar);
		springLayout.putConstraint(SpringLayout.WEST, OveralProcessBar, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, OveralProcessBar, -162, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, OveralProcessBar, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		frmExcelSmartImage.getContentPane().add(OveralProcessBar);
		
		lblExcelPathNum = new JLabel("Unknown");
		springLayout.putConstraint(SpringLayout.NORTH, lblExcelPathNum, 0, SpringLayout.NORTH, lblExcel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblExcelPathNum, 6, SpringLayout.EAST, lblExcel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblExcelPathNum, -15, SpringLayout.WEST, label_1);
		lblExcelPathNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcelPathNum);
		
		lblImagePathNum = new JLabel("Unknown");
		springLayout.putConstraint(SpringLayout.WEST, lblImagePathNum, 402, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblImagePathNum, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_1, -6, SpringLayout.WEST, lblImagePathNum);
		springLayout.putConstraint(SpringLayout.NORTH, lblImagePathNum, 0, SpringLayout.NORTH, lblExcel_1);
		lblImagePathNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblImagePathNum);
		
		lblExcelFileNum = new JLabel("Unknown");
		springLayout.putConstraint(SpringLayout.WEST, lblExcelFileNum, 164, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblExcel, -6, SpringLayout.WEST, lblExcelFileNum);
		springLayout.putConstraint(SpringLayout.NORTH, lblExcelFileNum, 0, SpringLayout.NORTH, lblExcel);
		springLayout.putConstraint(SpringLayout.EAST, lblExcelFileNum, -6, SpringLayout.WEST, label_1);
		lblExcelFileNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcelFileNum);
		
		lblImageFileNum = new JLabel("Unknown");
		springLayout.putConstraint(SpringLayout.NORTH, lblImageFileNum, 2, SpringLayout.NORTH, lblExcel);
		springLayout.putConstraint(SpringLayout.WEST, lblImageFileNum, 6, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.EAST, lblImageFileNum, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		lblImageFileNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblImageFileNum);
		
		lblCurrentProcess = new JLabel("Unknown");
		springLayout.putConstraint(SpringLayout.NORTH, lblCurrentProcess, 0, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, lblCurrentProcess, 6, SpringLayout.EAST, label_2);
		springLayout.putConstraint(SpringLayout.EAST, lblCurrentProcess, -15, SpringLayout.WEST, label_3);
		lblCurrentProcess.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblCurrentProcess);
		
		lblOveralProcess = new JLabel("Unknown");
		springLayout.putConstraint(SpringLayout.NORTH, lblOveralProcess, 0, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, lblOveralProcess, 0, SpringLayout.WEST, lblImagePathNum);
		springLayout.putConstraint(SpringLayout.EAST, lblOveralProcess, -61, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		lblOveralProcess.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblOveralProcess);
		post_initialize_process();
	}

	public JTextField getPrimeStatu()
	{
		return txtPrimeStatu;
	}
	public JTextField getSecondaryStatu()
	{
		return txtSecondaryStatu;
	}
	public JProgressBar getOveralProcessBar() {
		return OveralProcessBar;
	}
	public JProgressBar getCurrentProcessBar() {
		return CurrentProcessBar;
	}
	public JLabel getLblExcelPathNum() {
		return lblExcelPathNum;
	}
	public JLabel getLblImagePathNum() {
		return lblImagePathNum;
	}
	public JLabel getLblExcelFileNum() {
		return lblExcelFileNum;
	}
	public JLabel getLblImageFileNum() {
		return lblImageFileNum;
	}
	public JLabel getLblCurrentProcess() {
		return lblCurrentProcess;
	}
	public JLabel getLblOveralProcess() {
		return lblOveralProcess;
	}
	public void UpdateCurrentPrograssBar(int val)
	{
		CurrentProcessBar.setValue(val);
		CurrentProcessBar.setString(val+"%");
		CurrentProcessBar.repaint();
	}
	public void UpdateOveralPrograssBar(int val)
	{
		OveralProcessBar.setValue(val);
		OveralProcessBar.setString(val+"%");
		OveralProcessBar.repaint();
	}
}
