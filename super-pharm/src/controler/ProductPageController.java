package controler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controler.EmployeePageController.btnBackListener;
import model.ProductPageModel;
import view.ProductPageView;

public class ProductPageController {
	private ProductPageView view;
	private ProductPageModel model;
	
	public ProductPageController(ProductPageView view, ProductPageModel model) {
		this.view = view;
		this.model = model;
		view.setBackBtnActionListener(new btnBackListener());
		view.setAddBtnActionListener(new btnAddListener());
		view.setDeleteBtnActionListener(new btnDeleteListener());
		view.setUpdateBtnActionListener(new btnUpdateListener());
		view.setTableContent(model.getProductList());
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
				
				if(!(validation())){
					return;
				}

				int price, quantity, dos;
				String id, name, department, type;
				
				id = view.getId();
				name = view.getName();
				department = view.getDepartment();
				price = view.getPrice();
				quantity = view.getQuantity();
				dos = view.getDos();
				type = view.getProductType();
				
				if(department.equals("General") && (!type.equals("") || !(dos==0))) {
					view.displayMessage("Type and dos are illegal in general department");
					return;
				}
				
				if(department.equals("Pharmacy") && type.equals("")) {
					view.displayMessage("Please enter product type");
					return;
				}
				
				if(type.equals("Adult") && dos < 6 ) {
					view.displayMessage("Dos is too low for adult!");
					return;
				}
				
				if(type.equals("Children") && dos > 5 ) {
					view.displayMessage("Dos is too high for children!");
					return;
				}
				

				
				if(model.addProduct(id, name, price, quantity, department, type, dos)) {
					
					view.setTableContent(model.getProductList());
					view.displayMessage("Item was added!");
				}else {
					view.displayMessage("Could not add item");
				}
				
			}
		}
		class btnDeleteListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(validation())){
					return;
				}

				if(model.deleteProduct(view.getId())) {
					view.setTableContent(model.getProductList());	
					view.displayMessage("Item was deleted!");
				}
				else
					view.displayMessage("Could not delete item");
	
			}
		}
		class btnUpdateListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(validation())){
					return;
				}

				int price, quantity, dos;
				String id, name, department, type;
				
				id = view.getId();
				name = view.getName();
				department = view.getDepartment();
				price = view.getPrice();
				quantity = view.getQuantity();
				dos = view.getDos();
				type = view.getProductType();
				
				if(department.equals("General") && (!type.equals("") || !(dos==0))) {
					view.displayMessage("Type and dos are illegal in general department");
					return;
				}
				
				if(department.equals("Pharmacy") && type.equals("")) {
					view.displayMessage("Please enter product type");
					return;
				}
				
				if(type.equals("Adult") && dos < 6 ) {
					view.displayMessage("Dos is too low for adult!");
					return;
				}
				
				if(type.equals("Children") && dos > 5 ) {
					view.displayMessage("Dos is too high for children!");
					return;
				}
				

				
				if(model.updateProduct(id, name, price, quantity, department, type, dos)) {
					
					view.setTableContent(model.getProductList());
					view.displayMessage("Item was updated!");
				}else {
					view.displayMessage("Could not update item");
				}
	
				
			}
		}
		
		public boolean validation() {
			

			String id, name, department, type, price, quantity, dos;
			
			id = view.getId();
			name = view.getName();
			department = view.getDepartment();
			price = view.getPriceAsString();
			quantity = view.getQuantityAsString();
			dos = view.getDosAsString();
			type = view.getProductType();
			
			if(id.equals("") || name.equals("") || price.equals("") || quantity.equals("") || dos.equals("")) {
				view.displayMessage("Fields can not be empty!");
				return false;
			}
			
			if(!(name.matches("[a-zA-Z]+"))) {
				view.displayMessage("Name can only contain letters!");
				return false;
			}
			
			if(!(id.matches("[0-9]+")) || !(price.matches("[0-9]+")) || !(quantity.matches("[0-9]+")) || !(dos.matches("[0-9]+"))) {
				view.displayMessage("id/price/quantity/dos can only contain positive integer!");
				return false;
			}
			
			return true;
		}
	
}


