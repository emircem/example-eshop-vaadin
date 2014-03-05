package cz.jiripinkas.example.view;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;

import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.layout.CustomView;

@VaadinComponent
public class HomeView extends CustomView {

	public HomeView() {
		super("EShop example using Vaadin");
		Label label = new Label("EShop example using Vaadin");
		mainLayout.addComponent(label);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
