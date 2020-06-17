package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controler.EmployeePageController.btnBackListener;
import model.OrderPageModel;
import view.OrderPageView;

public class OrderPageController {
	private OrderPageView view;
	private OrderPageModel model;
	
	public OrderPageController(OrderPageView view, OrderPageModel model) {
		this.view = view;
		this.model = model;
		view.setBackBtnActionListener(new btnBackListener());
		view.setAddBtnActionListener(new btnAddListener());
		view.setPlaceOrderBtnActionListener(new btnPlaceOrderListener());
		view.setRemoveBtnActionListener(new btnRemoveListener());
		view.setTableContent(model.getProductsList());
		}
		class btnBackListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.setVisible(false);
				view.dispose();
				model.moveToMainMenuPage();
				
			}
		}
		
		class btnAddListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!checkValidation())
					return;
				
				String id = view.getId();
				int currentQuantity = model.getItemQuantity(id);
				int orderQuantity = Integer.parseInt(view.getQuantity());
				
				if(model.isItemInOrderMap(id)) {
					view.removeRowByValue(id);
				}
				int updatedQuantity = currentQuantity - orderQuantity;
				
				
				model.addToOrderListMap(id, Integer.toString(updatedQuantity));
				
				view.addToOrderTable();
				
			}
		}
		
		class btnPlaceOrderListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.isOrderTableEmpty()) {
					view.displayMessage("Order is empty! please add items to your oreder");
					return;
				}
					
				model.placeOrder();
				view.displayMessage("Order placed!");
				view.setTableContent(model.getProductsList());
				view.clearOrderTable();
			}
		}
		
		class btnRemoveListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.removeFromOrderListMap(view.removeRow());
			}
		}
		
		public boolean checkValidation() {
			String id = view.getId();
			String quantity = view.getQuantity();
			
			if(id.equals("")) {
				view.displayMessage("Please select item first");
				return false;
			}
			
			if(quantity.equals("")) {
				view.displayMessage("Quantity can not be empty");
				return false;
			}
			if(quantity.matches("[0-9]+")== false) {
				view.displayMessage("Quantity can only contain positive numbers!");
				return false;
			}
			
			int currentQuantity = model.getItemQuantity(id);
			int orderQuantity = Integer.parseInt(view.getQuantity());
			
			if(orderQuantity > currentQuantity) {
				view.displayMessage("Quantity is low than request");
				return false;
			}
		
			return true;
		}
}
