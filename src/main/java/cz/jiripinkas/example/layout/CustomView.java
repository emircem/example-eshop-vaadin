package cz.jiripinkas.example.layout;

import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public abstract class CustomView extends CustomComponent implements View {

	protected VerticalLayout mainLayout;

	private Label titleLabel;

	public CustomView(String title) {
		mainLayout = new VerticalLayout();
		titleLabel = new Label();
		titleLabel.setContentMode(ContentMode.HTML);
		mainLayout.addComponent(titleLabel);
		setTitle(title);
		setCompositionRoot(mainLayout);
	}

	public void setTitle(String title) {
		titleLabel.setValue("<h1>" + title + "</h1>");
	}

}