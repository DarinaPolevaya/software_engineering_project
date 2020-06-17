package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import org.w3c.dom.events.MouseEvent;

import model.EmployeePageModel;
import view.EmployeePageView;

public class EmployeePageController {
	private EmployeePageView view;
	private EmployeePageModel model;
	
	public EmployeePageController(EmployeePageView view, EmployeePageModel model) {
		this.view = view;
		this.model = model;
		view.setBackBtnActionListener(new btnBackListener());
		view.setAddBtnActionListener(new btnAddListener());
		view.setDeleteBtnActionListener(new btnDeleteListener());
		view.setUpdateBtnActionListener(new btnUpdateListener());
		view.setTableContent(model.getUsersList());

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
			
			if(!validation())
				return;
			
			String id = view.getId();
			if((model.isUser(id))) {
				view.displayMessage("You can't use tha same id for more than one user!");
				return;
			}
				
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			boolean manager = view.isManager();
			
			if(model.addUser(id, firstName, lastName, manager)) {
				view.clearAllFields();
				view.displayMessage("User was succesfully added");
				view.setTableContent(model.getUsersList());
			}
			else {
				view.displayMessage("Could not add new user");
			}
			
		}
	}class btnDeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(!validation())
				return;
			
			String id = view.getId();
			
			if(model.deleteUser(id)) {
				view.displayMessage("Usere was deleted!");
				view.setTableContent(model.getUsersList());
				view.clearAllFields();
			}else {
				view.displayMessage("Could not delete user");
			}
			
		}
	}class btnUpdateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(!validation())
				return;
			
			String id = view.getId();
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			
			if(model.updateUser(id, firstName, lastName)) {
				view.clearAllFields();
				view.displayMessage("User was succesfully updated");
				view.setTableContent(model.getUsersList());
			}
			else {
				view.displayMessage("Could not update user Or user was not found");
			}
			
		}
	}
	
	public boolean validation() {
		
		String id = view.getId();
		String firstName = view.getFirstName();
		String lastName = view.getLastName();
			
		
		if(id.equals("") || firstName.equals("") || lastName.equals("")) {
			view.displayMessage("Fields can not be empty!");
			return false;
		}
		
		if(!(id.matches("[0-9]+"))) {
			view.displayMessage("Id can only contain positive integer!");
			return false;
		}
		
		if(!(firstName.matches("[a-zA-Z]+")) || !(lastName.matches("[a-zA-Z]+"))) {
			view.displayMessage("First name and last name can only contain letters!");
			return false;
		}
		
		
		
		return true;
	
	}
	
	
}
