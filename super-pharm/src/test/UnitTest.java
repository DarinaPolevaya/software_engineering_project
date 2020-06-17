package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.Database;
import util.Employee;
import util.GeneralProduct;

class UnitTest {
	
	Database db = Database.getInstance();

	@Test
	public void addEmployeeTest() {  
		
		
		Employee emp = new Employee("1111", "FirstNameTest", "LastNameTest");
		
		db.addNewUser(emp.getId(), emp.getFirstName(), emp.getLastName(), false);
		
		
		assertTrue(db.isEmployee(emp.getId()));
	}
	
	@Test
	public void deleteEmployeeTest() {  
		
		
		Employee emp = new Employee("1111", "FirstNameTest", "LastNameTest");
		
		db.deleteUser(emp.getId());
		
		
		assertFalse(db.isEmployee(emp.getId()));
	}
	
	
	@Test
	public void addProductTest() { 
		
		
		GeneralProduct product = new GeneralProduct(1111, 1111, "ProductNameTest", "TestDepartment", "121212");
		
		db.addProduct(product.getProductId(), product.getName(), product.getPrice(), product.getQuantity(), product.getDepartment(), "", 0);
		
		assertTrue(db.isProduct(product.getProductId()));

	}
	
	@Test
	public void changeProductQuantityTest() {  
		
		
		GeneralProduct product = new GeneralProduct(1111, 1111, "ProductNameTest", "TestDepartment", "121212");
		
		
		db.updateProduct(product.getProductId(), product.getName(), product.getPrice(), 123456, product.getDepartment(), "", 0);
	
		
		assertEquals(db.getProductQuantity(product.getProductId()), 123456);
		

	}
	
	@Test
	public void deleteProductTest() {  
		
		
		GeneralProduct product = new GeneralProduct(1111, 1111, "ProductNameTest", "TestDepartment", "121212");
		
		db.deleteProduct(product.getProductId());
		
		assertFalse(db.isProduct(product.getProductId()));

	}
	

}
