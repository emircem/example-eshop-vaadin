package cz.jiripinkas.example.component;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.themes.Reindeer;

public class SaveButton extends NativeButton {
	public SaveButton() {
		setClickShortcut(KeyCode.ENTER);
		addStyleName(Reindeer.BUTTON_DEFAULT);
		setCaption("Save");
	}
}