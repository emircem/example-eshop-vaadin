package cz.jiripinkas.example.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;

import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.entity.UserOrder;
import cz.jiripinkas.example.layout.CustomView;
import cz.jiripinkas.example.service.UserOrderService;

@VaadinComponent
public class UserOrdersView extends CustomView {

	@Autowired
	private UserOrderService userOrderService;

	private Table table;

	public UserOrdersView() {
		super("User orders");
		table = new Table();
		table.setSizeFull();
		mainLayout.addComponent(table);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		List<UserOrder> userOrders = userOrderService.findAll();
		final IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("name", String.class, null);
		container.addContainerProperty("city", String.class, null);
		container.addContainerProperty("street", String.class, null);
		container.addContainerProperty("zip", String.class, null);
		container.addContainerProperty("orderDate", String.class, null);
		container.addContainerProperty("orderedItems", String.class, null);
		for (UserOrder userOrder : userOrders) {
			Item item = container.addItem(userOrder.getId());
			Property<String> propertyName = item.getItemProperty("name");
			propertyName.setValue(userOrder.getName());
			Property<String> propertyCity = item.getItemProperty("city");
			propertyCity.setValue(userOrder.getCity());
			Property<String> propertyStreet = item.getItemProperty("street");
			propertyStreet.setValue(userOrder.getStreet());
			Property<String> propertyZip = item.getItemProperty("zip");
			propertyZip.setValue(userOrder.getZip());
			Property<String> propertyOrderDate = item.getItemProperty("orderDate");
			propertyOrderDate.setValue("" + userOrder.getOrderDate());
			Property<String> propertyOrderedItems = item.getItemProperty("orderedItems");
			propertyOrderedItems.setValue("" + userOrder.getOrderedItems().size());
		}
		table.setContainerDataSource(container);
		table.setColumnHeader("orderDate", "order date");
		table.setColumnHeader("orderedItems", "ordered items");
	}

}
