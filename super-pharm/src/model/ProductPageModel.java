package model;

import java.sql.ResultSet;

import database.Database;
import util.ViewManager;

public class ProductPageModel {
	
	private ViewManager viewManager = ViewManager.getInstance();
	private Database db = Database.getInstance();
	
	
	public void moveToMainMenuPage() {
		viewManager.moveToMainMenuPage();
	}
	
	public ResultSet getProductList() {
		return db.getProductsList();
	}
	
	public boolean deleteProduct(String id) {
		return db.deleteProduct(id);
	}
	
	public boolean updateProduct(String id, String name, int price, int quantity, String department, String type, int dos) {
		String newType;
		
		if(type.equals("")) {
			newType = null;
		}else
			newType = type;
		
		
		return db.updateProduct(id, name, price, quantity, department, newType, dos);
	}
	
	public boolean addProduct(String id, String name, int price, int quantity, String department, String type, int dos) {
		String newType;
		
		if(type.equals("")) {
			newType = null;
		}else
			newType = type;
		
		
		return db.addProduct(id, name, price, quantity, department, newType, dos);
	}

}
