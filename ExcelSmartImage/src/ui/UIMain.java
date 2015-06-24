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

import ESI.ExcelManger;
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
		frmExcelSmartImage.getContentPane().setLayout(springLayout);
		
		btnStart = new JButton("\u5F00\u59CB");
		springLayout.putConstraint(SpringLayout.EAST, btnStart, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcelManger.start();
			}
		});
		frmExcelSmartImage.getContentPane().add(btnStart);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, -376, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
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
		springLayout.putConstraint(SpringLayout.NORTH, txtPrimeStatu, 387, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		txtPrimeStatu.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, txtSecondaryStatu, 0, SpringLayout.NORTH, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.EAST, txtSecondaryStatu, 0, SpringLayout.WEST, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.WEST, txtPrimeStatu, 91, SpringLayout.WEST, menuBar);
		txtPrimeStatu.setEditable(false);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPrimeStatu, 0, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtPrimeStatu, 0, SpringLayout.EAST, menuBar);
		frmExcelSmartImage.getContentPane().add(txtPrimeStatu);
		txtPrimeStatu.setColumns(10);
		txtSecondaryStatu.setEditable(false);
		frmExcelSmartImage.getContentPane().add(txtSecondaryStatu);
		txtSecondaryStatu.setColumns(10);
		
		btnChangeSetting = new JButton("\u66F4\u6539\u914D\u7F6E");
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 0, SpringLayout.WEST, btnChangeSetting);
		springLayout.putConstraint(SpringLayout.SOUTH, btnStart, -6, SpringLayout.NORTH, btnChangeSetting);
		btnChangeSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UILoader.loadConfigWindow(null);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnChangeSetting, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnChangeSetting, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnChangeSetting, -40, SpringLayout.NORTH, txtPrimeStatu);
		springLayout.putConstraint(SpringLayout.SOUTH, btnChangeSetting, -6, SpringLayout.NORTH, txtPrimeStatu);
		frmExcelSmartImage.getContentPane().add(btnChangeSetting);
		
		lblExcel = new JLabel("Excel \u8868\u683C\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, lblExcel, 0, SpringLayout.WEST, btnStart);
		springLayout.putConstraint(SpringLayout.SOUTH, lblExcel, 98, SpringLayout.SOUTH, menuBar);
		lblExcel.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcel);
		
		label = new JLabel("\u56FE\u7247\u6587\u4EF6\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label, 112, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblExcel, -3, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.EAST, lblExcel, -133, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.WEST, label, 291, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		label.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label);
		
		lblExcel_1 = new JLabel("Excel \u8DEF\u5F84\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, lblExcel_1, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblExcel_1, -323, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		lblExcel_1.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcel_1);
		
		label_1 = new JLabel("\u56FE\u7247\u8DEF\u5F84\u6570\u91CF\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 71, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label_1);
		
		label_2 = new JLabel("\u5F53\u524D\u8868\u683C\u5DF2\u5904\u7406\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, btnStart);
		label_2.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u603B\u8FDB\u5EA6\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 21, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, label_3);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		label_3.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(label_3);
		
		CurrentProcessBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, CurrentProcessBar, 52, SpringLayout.SOUTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, CurrentProcessBar, 0, SpringLayout.WEST, btnStart);
		springLayout.putConstraint(SpringLayout.EAST, CurrentProcessBar, 0, SpringLayout.EAST, btnStart);
		frmExcelSmartImage.getContentPane().add(CurrentProcessBar);
		
		OveralProcessBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, OveralProcessBar, 246, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, OveralProcessBar, -141, SpringLayout.SOUTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, CurrentProcessBar, -6, SpringLayout.NORTH, OveralProcessBar);
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 38, SpringLayout.SOUTH, OveralProcessBar);
		springLayout.putConstraint(SpringLayout.WEST, OveralProcessBar, 0, SpringLayout.WEST, btnStart);
		springLayout.putConstraint(SpringLayout.EAST, OveralProcessBar, 0, SpringLayout.EAST, btnStart);
		frmExcelSmartImage.getContentPane().add(OveralProcessBar);
		
		lblExcelPathNum = new JLabel("\u672A\u77E5");
		springLayout.putConstraint(SpringLayout.NORTH, lblExcelPathNum, 0, SpringLayout.NORTH, lblExcel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblExcelPathNum, 6, SpringLayout.EAST, lblExcel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblExcelPathNum, 17, SpringLayout.NORTH, lblExcel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblExcelPathNum, -15, SpringLayout.WEST, label_1);
		lblExcelPathNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcelPathNum);
		
		lblImagePathNum = new JLabel("\u672A\u77E5");
		springLayout.putConstraint(SpringLayout.NORTH, lblImagePathNum, -16, SpringLayout.SOUTH, lblExcel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblImagePathNum, 6, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblImagePathNum, 0, SpringLayout.SOUTH, lblExcel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblImagePathNum, 0, SpringLayout.EAST, btnStart);
		lblImagePathNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblImagePathNum);
		
		lblExcelFileNum = new JLabel("\u672A\u77E5");
		springLayout.putConstraint(SpringLayout.NORTH, lblExcelFileNum, 24, SpringLayout.SOUTH, lblExcelPathNum);
		springLayout.putConstraint(SpringLayout.WEST, lblExcelFileNum, 6, SpringLayout.EAST, lblExcel);
		springLayout.putConstraint(SpringLayout.EAST, lblExcelFileNum, -6, SpringLayout.WEST, label);
		lblExcelFileNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblExcelFileNum);
		
		lblImageFileNum = new JLabel("\u672A\u77E5");
		springLayout.putConstraint(SpringLayout.NORTH, lblImageFileNum, 22, SpringLayout.SOUTH, lblImagePathNum);
		springLayout.putConstraint(SpringLayout.WEST, lblImageFileNum, 6, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.EAST, lblImageFileNum, 0, SpringLayout.EAST, btnStart);
		lblImageFileNum.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblImageFileNum);
		
		lblCurrentProcess = new JLabel("\u672A\u77E5");
		springLayout.putConstraint(SpringLayout.NORTH, lblCurrentProcess, 149, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCurrentProcess, 164, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblCurrentProcess, -52, SpringLayout.NORTH, CurrentProcessBar);
		springLayout.putConstraint(SpringLayout.SOUTH, lblExcelFileNum, -21, SpringLayout.NORTH, lblCurrentProcess);
		springLayout.putConstraint(SpringLayout.EAST, lblCurrentProcess, 0, SpringLayout.EAST, lblExcelPathNum);
		lblCurrentProcess.setFont(new Font("SimSun", Font.BOLD, 14));
		frmExcelSmartImage.getContentPane().add(lblCurrentProcess);
		
		lblOveralProcess = new JLabel("\u672A\u77E5");
		springLayout.putConstraint(SpringLayout.NORTH, lblOveralProcess, 149, SpringLayout.NORTH, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblOveralProcess, -52, SpringLayout.NORTH, CurrentProcessBar);
		springLayout.putConstraint(SpringLayout.SOUTH, lblImageFileNum, -17, SpringLayout.NORTH, lblOveralProcess);
		springLayout.putConstraint(SpringLayout.WEST, lblOveralProcess, 0, SpringLayout.WEST, lblImagePathNum);
		springLayout.putConstraint(SpringLayout.EAST, lblOveralProcess, 84, SpringLayout.WEST, lblImagePathNum);
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
}
