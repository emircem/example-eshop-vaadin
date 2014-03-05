package cz.jiripinkas.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.borderlayout.BorderLayout;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.domain.Basket;
import cz.jiripinkas.example.layout.Footer;
import cz.jiripinkas.example.layout.Menu;
import cz.jiripinkas.example.view.BasketView;
import cz.jiripinkas.example.view.HomeView;
import cz.jiripinkas.example.view.ItemDetailView;
import cz.jiripinkas.example.view.ItemFormView;
import cz.jiripinkas.example.view.ItemsView;
import cz.jiripinkas.example.view.UserOrdersView;

@PreserveOnRefresh
@VaadinComponent
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	private Navigator navigator;

	private Basket basket;

	public static final String HOME_VIEW = "";
	public static final String ITEMS_VIEW = "items";
	public static final String ITEM_DETAIL_VIEW = "item-detail";
	public static final String ITEM_FORM_VIEW = "item-form";
	public static final String BASKET_VIEW = "basket";
	public static final String USER_ORDERS_VIEW = "user-orders";

	@Autowired
	private HomeView homeView;

	@Autowired
	private ItemsView itemsView;

	@Autowired
	private ItemDetailView itemDetailView;

	@Autowired
	private ItemFormView itemFormView;

	@Autowired
	private BasketView basketView;
	
	@Autowired
	private UserOrdersView userOrdersView;

	@Override
	protected void init(VaadinRequest request) {
		navigator = new Navigator(this, constructContent());
		navigator.addView(HOME_VIEW, homeView);
		navigator.addView(ITEMS_VIEW, itemsView);
		navigator.addView(ITEM_DETAIL_VIEW, itemDetailView);
		navigator.addView(ITEM_FORM_VIEW, itemFormView);
		navigator.addView(BASKET_VIEW, basketView);
		navigator.addView(USER_ORDERS_VIEW, userOrdersView);
		basket = new Basket();
	}

	private VerticalLayout constructContent() {
		VerticalLayout mainLayout = new VerticalLayout();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setMinimumNorthHeight("20px");
		borderLayout.setMinimumWestWidth("20px");
		borderLayout.setMinimumEastWidth("20px");
		borderLayout.addComponent(new VerticalLayout(new Menu()), BorderLayout.Constraint.NORTH);
		borderLayout.addComponent(mainLayout, BorderLayout.Constraint.CENTER);
		borderLayout.addComponent(new Footer(), BorderLayout.Constraint.SOUTH);
		borderLayout.addComponent(new HorizontalLayout(), BorderLayout.Constraint.WEST);
		borderLayout.addComponent(new HorizontalLayout(), BorderLayout.Constraint.EAST);
		setContent(borderLayout);
		return mainLayout;
	}

	public Basket getBasket() {
		return basket;
	}
}
