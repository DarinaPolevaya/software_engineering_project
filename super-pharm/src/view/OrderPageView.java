package view;

import java.awt.BorderLayout;
import java.awt.DefaultFocusTraversalPolicy;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class OrderPageView extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTable tableProduct;
	private JScrollPane scrollPane;
	private JLabel lblProducts;
	private JTable tableOrder;
	private JScrollPane scrollPane_1;
	private JLabel lblOrder;
	private JButton btnAdd;
	private JButton btnPlaceOrder;
	private JTextField textFieldId;
	private JLabel lblProductId;
	private JTextField textFieldQuantity;
	private JLabel lblQuantity;
	private JButton btnRemove;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPageView frame = new OrderPageView();
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
	public OrderPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderPage = new JLabel("Order Page");
		lblOrderPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblOrderPage.setBounds(222, 11, 183, 54);
		contentPane.add(lblOrderPage);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(48, 401, 89, 23);
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 86, 364, 273);
		contentPane.add(scrollPane);
		
		tableProduct = new JTable();
		scrollPane.setViewportView(tableProduct);
		
		lblProducts = new JLabel("products");
		lblProducts.setBounds(48, 65, 46, 14);
		contentPane.add(lblProducts);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(428, 88, 137, 273);
		contentPane.add(scrollPane_1);
		
		model = new DefaultTableModel();
		
		tableOrder = new JTable(model);
		scrollPane_1.setViewportView(tableOrder);
		
		model.addColumn("id"); 
		model.addColumn("quantity");
		
		
		
		lblOrder = new JLabel("order");
		lblOrder.setBounds(436, 65, 46, 14);
		contentPane.add(lblOrder);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(316, 401, 89, 23);
		contentPane.add(btnAdd);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(436, 401, 89, 23);
		contentPane.add(btnPlaceOrder);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(181, 379, 86, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		lblProductId = new JLabel("Product id:");
		lblProductId.setBounds(181, 366, 62, 14);
		contentPane.add(lblProductId);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(181, 419, 86, 20);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(178, 405, 46, 14);
		contentPane.add(lblQuantity);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(438, 372, 89, 23);
		contentPane.add(btnRemove);
		
		tableProduct.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableProduct.getSelectedRow();
				String id = tableProduct.getModel().getValueAt(row, 0).toString();
				textFieldId.setText(id);
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
		
		public void setPlaceOrderBtnActionListener(ActionListener actionListener) {
			this.btnPlaceOrder.addActionListener(actionListener);
		}
		
		public void setRemoveBtnActionListener(ActionListener actionListener) {
			this.btnRemove.addActionListener(actionListener);
		}

		
		public void setTableContent(ResultSet rs) {
			tableProduct.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		public String getId() {
			return this.textFieldId.getText();
		}
		
		public String getQuantity() {
			return this.textFieldQuantity.getText();
		}
		
		public void addToOrderTable() {
			DefaultTableModel tableModel = (DefaultTableModel) tableOrder.getModel();
			String id = getId();
			String quantity = getQuantity();
						
			tableModel.addRow(new Object[] {id, quantity});
		}
		
		public String removeRow() {
			int row = tableOrder.getSelectedRow();
			
			if(row != -1) {
				String id = tableOrder.getModel().getValueAt(row, 0).toString();
				((DefaultTableModel)tableOrder.getModel()).removeRow(row);
				return id;
			}
			
			return "0";
		}
		
		public void removeRowByValue(String id) {
			int rowCount = tableOrder.getModel().getRowCount();
			for(int i=0; i<rowCount;i++) {
				String idFromTable = tableOrder.getModel().getValueAt(i, 0).toString();
				if(id.equals(idFromTable)) {
					((DefaultTableModel)tableOrder.getModel()).removeRow(i);
					return;
				}
			}
		}
		
		public boolean isOrderTableEmpty() {
			int row = tableOrder.getModel().getRowCount();			
			return row == 0;
		}
		
		public void clearOrderTable() {
			this.model.setRowCount(0);
		}
		
		public void displayMessage(String Message){
	         
		    JOptionPane.showMessageDialog(this,Message);
			
			 }
}
