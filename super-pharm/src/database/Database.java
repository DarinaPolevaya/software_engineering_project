package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.html.parser.ParserDelegator;

import util.Employee;

public class Database {
	private static Database instance=null;
	private Database () {}
	public static Database getInstance() 
	{
		if(instance==null)
		{
			instance=new Database();
		}
		return instance;
	}
	
	private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:src/database/SuperPharmDb.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
	}
	
	public boolean isManager(String id){  
   	 String sql = "SELECT * FROM manager where id = " + id;  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
   }
	
	public boolean isEmployee(String id){  
	   	 String sql = "SELECT * FROM employee where id = " + id;  

	        
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  

	            boolean isEmpty = !rs.isBeforeFirst();
	            
	            if (isEmpty) {
	           	 rs.close();
	           	 return false;
	            }
	            
	            else {
	           	 rs.close();
	           	 return true;
	            }
	             

	       } catch (SQLException e) {  
	           System.out.println(e.getMessage());  
	       }  
	       
	       return false;
	   }
	
	public boolean addNewUser(String id, String firstName, String lastName, boolean manager) {
		
		if(manager) {
			String sql = "INSERT INTO manager (first_name, last_name, id) VALUES(?,?,?)";

	        
	        try {  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, firstName);
	            pstmt.setString(2, lastName);
	            pstmt.setString(3, id);
	            pstmt.executeUpdate();
	            pstmt.close();
	            return true;

        
	  
	       } catch (SQLException e) {  
	           System.out.println(e.getMessage());  
	           return false;
	       }  
	       
	      
	
		}
		else{
			 String sql = "INSERT INTO employee (first_name, last_name, id) VALUES(?,?,?)";

		        
		        try {  
		            Connection conn = this.connect();  
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, firstName);
		            pstmt.setString(2, lastName);
		            pstmt.setString(3, id);
		            pstmt.executeUpdate();
		            pstmt.close();
		            return true;

	        
		  
		       } catch (SQLException e) {  
		           System.out.println(e.getMessage());  
			       return false;
		       }  

		}
		
		}
   	   	
	
public boolean updateUser(String id, String firstName, String lastName) {
	
			
		if(this.isManager(id)) {
			String sql = "UPDATE manager SET first_name = ?, last_name = ? WHERE id = ?";

	        
	        try {  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, firstName);
	            pstmt.setString(2, lastName);
	            pstmt.setString(3, id);
	            pstmt.executeUpdate();
	            pstmt.close();
	            return true;

        
	  
	       } catch (SQLException e) {  
	           System.out.println(e.getMessage());  
	           return false;
	       }  
	       
	      
	
		}
		else if(this.isEmployee(id)){
			 String sql = "UPDATE employee SET first_name = ?, last_name = ? WHERE id = ?";

		        
		        try {  
		            Connection conn = this.connect();  
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, firstName);
		            pstmt.setString(2, lastName);
		            pstmt.setString(3, id);
		            pstmt.executeUpdate();
		            pstmt.close();
		            return true;

	        
		  
		       } catch (SQLException e) {  
		           System.out.println(e.getMessage());  
			       return false;
		       }  

		}
		else
			return false;
		
		}

public boolean deleteUser(String id) {
	
	
	if(this.isManager(id)) {
		String sql = "DELETE FROM manager where id = ?";

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

    
  
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
           return false;
       }  
       
      

	}
	else if(this.isEmployee(id)){
		 String sql = "DELETE FROM employee where id = ?";

	        
	        try {  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
	            pstmt.executeUpdate();
	            pstmt.close();
	            return true;

        
	  
	       } catch (SQLException e) {  
	           System.out.println(e.getMessage());  
		       return false;
	       }  

	}
	else
		return false;
	
	}

public ResultSet getUsersList() {
	String sql = "SELECT * FROM manager UNION SELECT * FROM employee" ;  

    
    try {  
        Connection conn = this.connect();  
        Statement stmt  = conn.createStatement();  
        ResultSet rs    = stmt.executeQuery(sql);  

        return rs;

   } catch (SQLException e) {  
       System.out.println(e.getMessage());  
   }  
   
   return null;
}

public ResultSet getProductsList() {
	String sql = "SELECT * FROM product" ;  

    
    try {  
        Connection conn = this.connect();  
        Statement stmt  = conn.createStatement();  
        ResultSet rs    = stmt.executeQuery(sql);  

        return rs;

   } catch (SQLException e) {  
       System.out.println(e.getMessage());  
   }  
   
   return null;
}

public boolean isUserExist(String id) {
	String sql = "SELECT * FROM manager where id = ? UNION SELECT * FROM employee where id = ?" ;  
	
    
    try {  
        Connection conn = this.connect();  
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, id);
        ResultSet rs = pstmt.executeQuery();
        
        
        boolean isEmpty = !rs.isBeforeFirst();
        
        if (isEmpty) {
          	 rs.close();
          	 return false;
           }
           
           else {
          	 rs.close();
          	 return true;
           }


   } catch (SQLException e) {  
       System.out.println(e.getMessage());  
   }  
   
   return false;
}


public boolean isProduct(String id){  
  	 String sql = "SELECT * FROM product where id = " + id;  

       
       try {  
           Connection conn = this.connect();  
           Statement stmt  = conn.createStatement();  
           ResultSet rs    = stmt.executeQuery(sql);  

           boolean isEmpty = !rs.isBeforeFirst();
           
           if (isEmpty) {
          	 rs.close();
          	 return false;
           }
           
           else {
          	 rs.close();
          	 return true;
           }
            

      } catch (SQLException e) {  
          System.out.println(e.getMessage());  
      }  
      
      return false;
  }

public Employee getEmployee(String id){  
 	 String sql = "SELECT * FROM employee where id = " + id;  

      
      try {  
          Connection conn = this.connect();  
          Statement stmt  = conn.createStatement();  
          ResultSet rs    = stmt.executeQuery(sql);  

          String firstName = rs.getString("first_name");
          String lastName = rs.getString("last_name");
          String empId = rs.getString("id");
          
          Employee emp = new Employee(empId, firstName, lastName);
          
          return emp;

          
           

     } catch (SQLException e) {  
         System.out.println(e.getMessage());  
     }  
     
     return null;
 }

public boolean deleteProduct(String id) {
	
	if(!isProduct(id))
		return false;
	
		String sql = "DELETE FROM product where id = ?";

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

    
  
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
           return false;
       }  
       
	}

public boolean updateProduct(String id, String name, int price, int quantity, String department, String type, int dos) {
	
	if(!isProduct(id))
		return false;
	
		String sql = "UPDATE product SET name = ?, price = ?, quantity = ?, department = ?, type = ?, dos = ? WHERE id = ?";

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, quantity);
            pstmt.setString(4, department);
            pstmt.setString(5, type);
            pstmt.setInt(6, dos);
            pstmt.setString(7, id);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

    
  
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
           return false;
       }  

	
	}

public boolean addProduct(String id, String name, int price, int quantity, String department, String type, int dos) {
	
	
		String sql = "INSERT INTO product (id, name, price, quantity, department, type, dos) VALUES (?,?,?,?,?,?,?)";

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, price);
            pstmt.setInt(4, quantity);
            pstmt.setString(5, department);
            pstmt.setString(6, type);
            pstmt.setInt(7, dos);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return true;

    
  
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
           return false;
       }  

	
	}

public int getProductQuantity(String id){  
  	 String sql = "SELECT quantity FROM product where id = " + id;  

       
       try {  
           Connection conn = this.connect();  
           Statement stmt  = conn.createStatement();  
           ResultSet rs    = stmt.executeQuery(sql);  
           int quantity = rs.getInt("quantity");
           stmt.close();
           conn.close();
           return quantity;

      } catch (SQLException e) {  
          System.out.println(e.getMessage());  
      }  
      
      return 0;
  }

public boolean updateProductQuantity(String id, int quantity) {
	
	if(!isProduct(id))
		return false;
	
		String sql = "UPDATE product SET quantity = ? WHERE id = ?";

        
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, quantity);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return true;

    
  
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
           return false;
       }  

	
	}
}
