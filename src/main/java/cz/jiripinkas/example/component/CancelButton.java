package cz.jiripinkas.example.component;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.NativeButton;

public class CancelButton extends NativeButton {
	public CancelButton() {
		setClickShortcut(KeyCode.ESCAPE);
		setCaption("Cancel");
	}
}