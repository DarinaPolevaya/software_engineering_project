package util;

public abstract class User {
	
	public User(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
protected String id;
protected String firstName, lastName;

public String getId() {return id;}
public String getFirstName() {return firstName;}
public String getLastName() {return lastName;}
public void setId(String id) {this.id=id;}
public void setFirstName(String firstName) {this.firstName=firstName;}
public void setLastName(String lastName) {this.lastName=lastName;}
}
