package model;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import database.Database;
import util.ViewManager;

public class OrderPageModel {
	private ViewManager viewManager = ViewManager.getInstance();
	private Database db = Database.getInstance();
	
	private HashMap<String, String> orderMap = new HashMap<>();
	
	public void moveToMainMenuPage() {
		viewManager.moveToMainMenuPage();
		
	}
	
	public ResultSet getProductsList() {
		return db.getProductsList();
	}
	
	public void addToOrderListMap(String id, String quantity) {
		orderMap.put(id, quantity);
	}
	
	public void removeFromOrderListMap(String id) {
		orderMap.remove(id);
	}
	
	public void printOrdersMap() {
		for(Map.Entry<String, String> entry : orderMap.entrySet()) {
			System.out.println("id: " + entry.getKey() + " quan: " +entry.getValue());
		}
	}
	
	public void placeOrder() {
		for(Map.Entry<String, String> entry : orderMap.entrySet()) {
			this.updteProductQuan(entry.getKey(), Integer.parseInt(entry.getValue()));
		}
		this.orderMap.clear();
	}
	
	public boolean isItemInOrderMap(String id) {
		return orderMap.containsKey(id);
	}
	
	public int getItemQuantity(String id) {
		return db.getProductQuantity(id);
	}
	
	public void updteProductQuan(String id, int quantity) {
		db.updateProductQuantity(id, quantity);
	}
}
