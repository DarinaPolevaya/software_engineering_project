package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JLabel lblPleaseWriteYour;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBackground(Color.LIGHT_GRAY);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setBounds(221, 101, 194, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		btnLogin = new JButton("Log in");
		btnLogin.setBounds(272, 375, 89, 23);
		contentPane.add(btnLogin);
		
		lblPleaseWriteYour = new JLabel("Please write your ID");
		lblPleaseWriteYour.setBounds(262, 63, 153, 26);
		contentPane.add(lblPleaseWriteYour);
	}
	
	//Methods:
	
	public String getId() {
		return this.txtId.getText();
	}
	public void setLoginBtnActionListener(ActionListener actionListener) {
		this.btnLogin.addActionListener(actionListener);
	}
	
	//Massage Dialog:
	public void displayMessage(String Message){
		         
	    JOptionPane.showMessageDialog(this,Message);
		
		 }
}
