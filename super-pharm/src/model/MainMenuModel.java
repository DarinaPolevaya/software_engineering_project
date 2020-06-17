package model;

import database.Database;
import util.ViewManager;

public class MainMenuModel {
	
	private ViewManager viewManager = ViewManager.getInstance();
	private Database db = Database.getInstance();
	
	public void moveToProductsPage() {
		viewManager.moveToProductPage();
	}

	public void moveToEmployeePage() {
		viewManager.moveToEmployeePage();
		
	}
	public void moveToOrderPage() {
		viewManager.moveToOrderPage();
		
	}
	public void moveToLogin() {
		viewManager.moveToLogInPage();
		
	}
	public boolean isManager(String id) {
		return db.isManager(id);
	}

}
