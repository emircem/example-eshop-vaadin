package cz.jiripinkas.example.component;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public abstract class CustomForm<T> extends CustomComponent {
	private VerticalLayout mainLayout;
	protected HorizontalLayout header, footer;
	protected FormLayout central;
	protected SaveButton saveButton;
	protected CancelButton cancelButton;

	private static final int DEFAULT_PIXELS_WIDTH = 400;

	protected int pixelsWidth;

	protected FieldGroup fieldGroup;

	public CustomForm() {
		this(DEFAULT_PIXELS_WIDTH);
	}

	public CustomForm(int pixelsWidth) {
		this.pixelsWidth = pixelsWidth;
		header = new HorizontalLayout();
		central = new FormLayout();
		footer = new HorizontalLayout();
		mainLayout = new VerticalLayout();
		mainLayout.addComponent(header);
		mainLayout.addComponent(central);
		mainLayout.addComponent(footer);
		setCompositionRoot(mainLayout);
		setSizeUndefined();
		saveButton = new SaveButton();
		cancelButton = new CancelButton();
		footer.addComponents(saveButton, cancelButton);
		footer.setSpacing(true);

		saveButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				onSave();
			}
		});

		cancelButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				onCancel();
			}
		});
	}

	public void setComponent(T component, Class<T> type) {
		fieldGroup = new BeanFieldGroup<T>(type);
		fieldGroup.setItemDataSource(new BeanItem<T>(component));
		fieldGroup.bindMemberFields(this);
	}

	public T getComponent() throws CommitException {
		fieldGroup.commit();
		BeanItem<T> beanItem = (BeanItem<T>) fieldGroup.getItemDataSource();
		return beanItem.getBean();
	}

	public void addComponents(Component... components) {
		for (Component component : components) {
			component.setWidth(pixelsWidth + "px");
		}
		central.addComponents(components);
	}

	public abstract void onSave();

	public abstract void onCancel();

}