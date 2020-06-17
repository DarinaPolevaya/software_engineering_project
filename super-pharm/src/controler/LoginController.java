package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controler.LoginController.btnLoginListener;
import model.LoginModel;
import view.LoginView;

public class LoginController {private LoginView view;
private LoginModel model;

public LoginController(LoginView view, LoginModel model) {
	this.view = view;
	this.model = model;
	view.setLoginBtnActionListener(new btnLoginListener());
}
class btnLoginListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String id = view.getId();
		if(model.moveToMainMenuPage(id)) {
			view.setVisible(false);
			view.dispose();
		}
		else {
			view.displayMessage("User can not found in DB");
		}
		
	}
}

}
