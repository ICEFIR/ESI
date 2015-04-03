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

public class UIMain {

	private JFrame frmExcelSmartImage;
	private JButton btnStart;
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
		
		btnStart = new JButton("\u5F00\u59CB");
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 35, SpringLayout.WEST, frmExcelSmartImage.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnStart, -45, SpringLayout.EAST, frmExcelSmartImage.getContentPane());
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcelManger.Start();
			}
		});
		frmExcelSmartImage.getContentPane().add(btnStart);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 301, SpringLayout.SOUTH, menuBar);
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
		springLayout.putConstraint(SpringLayout.SOUTH, btnStart, -18, SpringLayout.NORTH, txtPrimeStatu);
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
		
	}
	
	public JTextField getPrimeStatu()
	{
		return txtPrimeStatu;
	}
	public JTextField getSecondaryStatu()
	{
		return txtSecondaryStatu;
	}
}
