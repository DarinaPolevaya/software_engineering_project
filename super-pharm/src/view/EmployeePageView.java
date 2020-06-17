package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;

public class EmployeePageView extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JLabel lblFirstName;
	private JTextField textFieldFirstName;
	private JTextField textFieldId;
	private JTextField textFieldLastName;
	private JTable table;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JCheckBox chckbxIsManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePageView frame = new EmployeePageView();
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
	public EmployeePageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeePage = new JLabel("Employee Page");
		lblEmployeePage.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblEmployeePage.setBounds(225, 11, 213, 69);
		contentPane.add(lblEmployeePage);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(43, 373, 81, 38);
		contentPane.add(btnBack);
		
		lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(522, 125, 64, 14);
		contentPane.add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(522, 141, 86, 20);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setBounds(522, 172, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(529, 219, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(522, 235, 86, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(522, 188, 86, 20);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setBounds(197, 381, 89, 23);
		contentPane.add(btnDelete);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(295, 381, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(394, 381, 89, 23);
		contentPane.add(btnUpdate);
		
		chckbxIsManager = new JCheckBox("Manager");
		chckbxIsManager.setBounds(522, 277, 97, 23);
		contentPane.add(chckbxIsManager);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 97, 417, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String id = table.getModel().getValueAt(row, 2).toString();
				textFieldId.setText(id);
				String lastName = table.getModel().getValueAt(row, 1).toString();
				textFieldLastName.setText(lastName);
				String firstName = table.getModel().getValueAt(row, 0).toString();
				textFieldFirstName.setText(firstName);
			}

		});
	}
	
	//Action listeners:
	
	public void setBackBtnActionListener(ActionListener actionListener) {
		this.btnBack.addActionListener(actionListener);
	}
	public void setAddBtnActionListener(ActionListener actionListener) {
		this.btnAdd.addActionListener(actionListener);
	}public void setDeleteBtnActionListener(ActionListener actionListener) {
		this.btnDelete.addActionListener(actionListener);
	}public void setUpdateBtnActionListener(ActionListener actionListener) {
		this.btnUpdate.addActionListener(actionListener);
	}


	
	
	//Setters and Getters:
	
	public String getFirstName() {
		return this.textFieldFirstName.getText();
	}
	
	public void setFirstName(String firstName) {
		this.textFieldFirstName.setText(firstName);
	}
	public String getLastName() {
		return this.textFieldLastName.getText();
	}
	
	public void setLastName(String lastName) {
		this.textFieldLastName.setText(lastName);
	}
	public String getId() {
		return this.textFieldId.getText();
	}
	
	public void setId(String id) {
		this.textFieldId.setText(id);
	}
	
	public boolean isManager() {
		return this.chckbxIsManager.isSelected();
	}
	
	public void setManager(boolean state) {
		this.chckbxIsManager.setSelected(state);
	}
	
	//Display message:
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this,message);
	}
	
	//Other Methods:
	public void clearAllFields() {
		this.textFieldFirstName.setText("");
		this.textFieldLastName.setText("");
		this.textFieldId.setText("");
		this.chckbxIsManager.setSelected(false);
	}
	
	public void setTableContent(ResultSet rs) {
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
}
