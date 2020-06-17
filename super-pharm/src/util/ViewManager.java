package util;

import controler.EmployeePageController;
import controler.LoginController;
import controler.MainMenuController;
import controler.OrderPageController;
import controler.ProductPageController;
import model.EmployeePageModel;
import model.LoginModel;
import model.MainMenuModel;
import model.OrderPageModel;
import model.ProductPageModel;
import view.EmployeePageView;
import view.LoginView;
import view.MainMenuView;
import view.OrderPageView;
import view.ProductPageView;

public class ViewManager {
private boolean isManager;
private static ViewManager instance=null;
private ViewManager () {}
public static ViewManager getInstance() 
{
	if(instance==null)
	{
		instance=new ViewManager();
	}
	return instance;
}

public boolean isManager() {
	return this.isManager;
}

public void setManager(boolean isManager) {
	this.isManager = isManager;
}

public void moveToMainMenuPage() {
	MainMenuView view = new MainMenuView();
	MainMenuModel model = new MainMenuModel();
	if(!isManager) {
		view.disableEmpBtn();
	}
	view.setVisible(true);
	MainMenuController controller = new MainMenuController(view, model);
}
public void moveToProductPage() {
	ProductPageView view = new ProductPageView();
	ProductPageModel model = new ProductPageModel();
	if(!isManager) {
		view.disableFieldsForEmp();
	}
	view.setVisible(true);
	ProductPageController controller = new ProductPageController(view, model);
}
public void moveToEmployeePage() {
	EmployeePageView view = new EmployeePageView();
	EmployeePageModel model = new EmployeePageModel();
	view.setVisible(true);
	EmployeePageController controller = new EmployeePageController(view, model);
}
public void moveToOrderPage() {
	OrderPageView view = new OrderPageView();
	OrderPageModel model = new OrderPageModel();
	view.setVisible(true);
	OrderPageController controller = new OrderPageController(view, model);
}
public void moveToLogInPage() {
	LoginView view = new LoginView();
	LoginModel model = new LoginModel();
	view.setVisible(true);
	LoginController controller = new LoginController(view, model);
}
}

