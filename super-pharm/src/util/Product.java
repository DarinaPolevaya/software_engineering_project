package util;

public class Product {
protected int price,quantity;
protected String name,department, productId;
public String getProductId() {return productId;}
public int getPrice() {return price;}
public int getQuantity() {return quantity;}
public String getName() {return name;}
public String getDepartment() {return department;}
public void setProductId(String productId) {this.productId=productId;}
public void setQuantity(int quantity) {this.quantity=quantity;}
public void setPrice(int price) {this.price=price;}
public void setName(String name) {this.name=name;}
public void setDepartment(String department) {this.department=department;}
public Product(int price, int quantity, String name, String department, String productId) {
	super();
	this.price = price;
	this.quantity = quantity;
	this.name = name;
	this.department = department;
	this.productId = productId;
}
public Product() {
	super();
}


}
