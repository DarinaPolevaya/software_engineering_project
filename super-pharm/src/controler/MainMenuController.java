package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainMenuModel;
import view.MainMenuView;

public class MainMenuController {
	
	private MainMenuView view;
	private MainMenuModel model;
	
	public MainMenuController(MainMenuView view, MainMenuModel model) {
		this.view = view;
		this.model = model;
		view.setProductsPageBtnActionListener(new btnProductsPageListener());
		view.setEmployeePageBtnActionListener(new btnEmployeePageListener());
		view.setOrderPageBtnActionListener(new btnOrderPageListener());
		view.setBackBtnActionListener(new btnBackListener());
	}
	
	class btnProductsPageListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.setVisible(false);
			view.dispose();
			model.moveToProductsPage();
			
		}
	}
	class btnBackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.setVisible(false);
			view.dispose();
			model.moveToLogin();
			
		}
	}
	class btnEmployeePageListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.setVisible(false);
			view.dispose();
			model.moveToEmployeePage();
			
		}
	}
	class btnOrderPageListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.setVisible(false);
			view.dispose();
			model.moveToOrderPage();
			
		}
	}

}
