package cz.jiripinkas.example.layout;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class Footer extends HorizontalLayout {

	public Footer() {
		Label copyrightLabel = new Label("&copy; Jiří Pinkas <a href='http://www.java-skoleni.cz' target='_blank'>Java školení</a> "
				+ "<a href='https://github.com/jirkapinkas/example-eshop-vaadin' target='_blank'>This project on GitHub</a>", ContentMode.HTML);
		addComponent(copyrightLabel);
		setSizeFull();
		copyrightLabel.setSizeUndefined();
		setComponentAlignment(copyrightLabel, Alignment.MIDDLE_CENTER);
	}
}
