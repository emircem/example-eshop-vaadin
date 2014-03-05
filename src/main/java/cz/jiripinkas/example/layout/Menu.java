package cz.jiripinkas.example.layout;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import cz.jiripinkas.example.MyVaadinUI;

public class Menu extends MenuBar {

	public Menu() {
		setWidth("100%");
		MenuItem mainItem = addItem("Main", null);
		mainItem.addItem("Home", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.HOME_VIEW);
			}
		});
		mainItem.addItem("Items", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEMS_VIEW);
			}
		});
		mainItem.addItem("Add item", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEM_FORM_VIEW);
			}
		});
		mainItem.addItem("Basket", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.BASKET_VIEW);
			}
		});
		mainItem.addItem("User orders", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.USER_ORDERS_VIEW);
			}
		});
	}
}
