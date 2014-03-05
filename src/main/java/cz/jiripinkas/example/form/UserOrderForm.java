package cz.jiripinkas.example.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import cz.jiripinkas.example.MyVaadinUI;
import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.component.CustomForm;
import cz.jiripinkas.example.domain.Basket;
import cz.jiripinkas.example.entity.UserOrder;
import cz.jiripinkas.example.service.BasketService;
import cz.jiripinkas.example.service.UserOrderService;

@VaadinComponent
public class UserOrderForm extends CustomForm<UserOrder> {

	private TextField name;
	private TextField city;
	private TextField street;
	private TextField zip;

	@Autowired
	private UserOrderService userOrderService;

	@Autowired
	private BasketService basketService;

	public UserOrderForm() {
		name = new TextField("Name:");
		city = new TextField("City:");
		street = new TextField("Street:");
		zip = new TextField("ZIP:");
		addComponents(name, city, street, zip);
	}

	@Override
	public void onSave() {
		try {
			UserOrder userOrder = getComponent();
			Basket basket = ((MyVaadinUI) UI.getCurrent()).getBasket();
			basketService.save(basket, userOrder);
			UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.USER_ORDERS_VIEW);
		} catch (CommitException e) {
		}
	}

	@Override
	public void onCancel() {
		UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.HOME_VIEW);
	}

}
