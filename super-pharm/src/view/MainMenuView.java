package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;

public class MainMenuView extends JFrame {

	private JPanel contentPane;
	private JButton btnProductsPage;
	private JButton btnEmployeePage;
	private JButton btnOrderPage;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuView frame = new MainMenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProductsPage = new JButton("Products Page");
		btnProductsPage.setBounds(68, 309, 129, 23);
		contentPane.add(btnProductsPage);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(253, 11, 187, 63);
		contentPane.add(lblNewLabel);
		
		btnEmployeePage = new JButton("Employee Page");
		btnEmployeePage.setBounds(253, 309, 129, 23);
		contentPane.add(btnEmployeePage);
		
		btnOrderPage = new JButton("Order Page");
		btnOrderPage.setBounds(486, 309, 89, 23);
		contentPane.add(btnOrderPage);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(68, 390, 89, 49);
		contentPane.add(btnBack);
	}
	
	public void disableEmpBtn() {
		this.btnEmployeePage.setEnabled(false);
	}
	
	
	//set Action Listeners
	
	public void setProductsPageBtnActionListener(ActionListener actionListener) {
		this.btnProductsPage.addActionListener(actionListener);
	}
	public void setEmployeePageBtnActionListener(ActionListener actionListener) {
		this.btnEmployeePage.addActionListener(actionListener);
	}
	public void setOrderPageBtnActionListener(ActionListener actionListener) {
		this.btnOrderPage.addActionListener(actionListener);
	}
	public void setBackBtnActionListener(ActionListener actionListener) {
		this.btnBack.addActionListener(actionListener);
	}
	}
