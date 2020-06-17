package model;

import java.sql.ResultSet;

import database.Database;
import util.ViewManager;

public class EmployeePageModel {
	
	private Database db = Database.getInstance();
	private ViewManager viewManager = ViewManager.getInstance();
	
	
	public void moveToMainMenuPage() {
		viewManager.moveToMainMenuPage();
		
	}
	
	public boolean addUser(String id, String firstName, String lastName, boolean manager) {
		return db.addNewUser(id, firstName, lastName, manager);
	}
	
	public boolean updateUser(String id, String firstName, String lastName) {
		return db.updateUser(id, firstName, lastName);
	}
	
	public boolean deleteUser(String id) {
		return(db.deleteUser(id));
	}
	public ResultSet getUsersList() {
		return db.getUsersList();
	}
	public boolean isUser(String id) {
		return db.isUserExist(id);
	}
}
