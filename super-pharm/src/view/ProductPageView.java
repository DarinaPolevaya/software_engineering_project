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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ProductPageView extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnAdd;
	private JTextField textFieldName;
	private JTextField textFieldProductId;
	private JTextField textFieldPrice;
	private JLabel lblName;
	private JLabel lblProductId;
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JTextField textFieldQuantity;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textFieldDos;
	private JLabel lblType;
	private JLabel lblDos;
	private JLabel lblDepartment;
	private JComboBox comboBoxDepartment;
	private JComboBox comboBoxType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductPageView frame = new ProductPageView();
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
	public ProductPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductPage = new JLabel("Product Page");
		lblProductPage.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProductPage.setBounds(215, 11, 151, 105);
		contentPane.add(lblProductPage);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(38, 385, 89, 23);
		contentPane.add(btnBack);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(172, 385, 89, 23);
		contentPane.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(271, 385, 89, 23);
		contentPane.add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(382, 385, 89, 23);
		contentPane.add(btnUpdate);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(508, 36, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldProductId = new JTextField();
		textFieldProductId.setBounds(508, 103, 86, 20);
		contentPane.add(textFieldProductId);
		textFieldProductId.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(508, 165, 86, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setBounds(508, 11, 46, 14);
		contentPane.add(lblName);
		
		lblProductId = new JLabel("Product Id");
		lblProductId.setBounds(508, 78, 74, 14);
		contentPane.add(lblProductId);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(508, 140, 46, 14);
		contentPane.add(lblPrice);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(508, 196, 46, 14);
		contentPane.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(508, 221, 86, 20);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 97, 457, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textFieldDos = new JTextField();
		textFieldDos.setBounds(508, 388, 86, 20);
		contentPane.add(textFieldDos);
		textFieldDos.setColumns(10);
		
		lblType = new JLabel("Type");
		lblType.setBounds(508, 309, 46, 14);
		contentPane.add(lblType);
		
		lblDos = new JLabel("Dos");
		lblDos.setBounds(508, 364, 46, 14);
		contentPane.add(lblDos);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(508, 252, 86, 14);
		contentPane.add(lblDepartment);
		
		comboBoxType = new JComboBox();
		comboBoxType.setBounds(508, 334, 86, 20);
		contentPane.add(comboBoxType);
		
		comboBoxType.addItem("Adult");
		comboBoxType.addItem("Children");
		comboBoxType.addItem("");
		
		comboBoxDepartment = new JComboBox();
		comboBoxDepartment.setBounds(508, 277, 86, 20);
		contentPane.add(comboBoxDepartment);
		
		comboBoxDepartment.addItem("Pharmacy");
		comboBoxDepartment.addItem("General");
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String id = table.getModel().getValueAt(row, 0).toString();
				textFieldProductId.setText(id);
				String name = table.getModel().getValueAt(row, 1).toString();
				textFieldName.setText(name);
				String price = table.getModel().getValueAt(row, 2).toString();
				textFieldPrice.setText(price);
				String quantity = table.getModel().getValueAt(row, 3).toString();
				textFieldQuantity.setText(quantity);
				String department = table.getModel().getValueAt(row, 4).toString();
				if(department.equals("Pharmacy")) {
					comboBoxDepartment.setSelectedIndex(0);
				}
				else {
					comboBoxDepartment.setSelectedIndex(1);
				}
				
				if(table.getModel().getValueAt(row, 5)!= null) {
					String type = table.getModel().getValueAt(row, 5).toString();
					comboBoxType.setSelectedItem(type);
				}
				else {
					comboBoxType.setSelectedItem("");
				}

				if(table.getModel().getValueAt(row, 6)!= null) {
					String dos = table.getModel().getValueAt(row, 6).toString();
					textFieldDos.setText(dos);
				}
				else {
					textFieldDos.setText("");
				}

			}
		});
	}
	//Action listeners:
	
		public void setBackBtnActionListener(ActionListener actionListener) {
			this.btnBack.addActionListener(actionListener);
		}
		public void setAddBtnActionListener(ActionListener actionListener) {
			this.btnAdd.addActionListener(actionListener);
		}
		public void setDeleteBtnActionListener(ActionListener actionListener) {
			this.btnDelete.addActionListener(actionListener);
		}
		public void setUpdateBtnActionListener(ActionListener actionListener) {
			this.btnUpdate.addActionListener(actionListener);
		}
		
		//getters and setters:
		public String getName() {
			return this.textFieldName.getText();
		}
		
		public String getId() {
			return this.textFieldProductId.getText();
		}
		
		public int getPrice() {
			return Integer.parseInt(this.textFieldPrice.getText());
		}
		
		public int getQuantity() {
			return Integer.parseInt(this.textFieldQuantity.getText());
		}
		
		public String getDepartment() {
			return comboBoxDepartment.getItemAt(comboBoxDepartment.getSelectedIndex()).toString();
		}
		
		public String getPriceAsString() {
			return this.textFieldPrice.getText();
		}
		
		public String getQuantityAsString() {
			return this.textFieldQuantity.getText();
		}
		
		public String getDosAsString() {
			return this.textFieldDos.getText();
		}
		
		public String getProductType() {
			return comboBoxType.getItemAt(comboBoxType.getSelectedIndex()).toString();
		}
		
		public int getDos() {
			if(this.textFieldDos.getText().equals(""))
			{
				return 0;
			}
			return Integer.parseInt(this.textFieldDos.getText());
		}
		
		
		//Other Methods:
		public void clearAllFields() {
			this.textFieldName.setText("");
			this.textFieldProductId.setText("");
			this.textFieldPrice.setText("");
			this.textFieldQuantity.setText("");
			

			this.textFieldDos.setText("");
		}
		public void setTableContent(ResultSet rs) {
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		public void disableFieldsForEmp() {
			this.btnAdd.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.btnUpdate.setEnabled(false);
		}
		
		
		public void displayMessage(String Message){
	         
		    JOptionPane.showMessageDialog(this,Message);
			
			 }
}
