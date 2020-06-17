package model;

import database.Database;
import util.ViewManager;

public class LoginModel {
	private ViewManager viewManager = ViewManager.getInstance();
	private Database db  = Database.getInstance();
	
	public boolean moveToMainMenuPage(String id) {
		
		if(db.isManager(id)) {
			viewManager.setManager(true);
			viewManager.moveToMainMenuPage();
			return true;
		}
		else if(db.isEmployee(id)) {
			viewManager.setManager(false);
			viewManager.moveToMainMenuPage();
			return true;
		}
		else {
			return false;
		}
		
	}
}
