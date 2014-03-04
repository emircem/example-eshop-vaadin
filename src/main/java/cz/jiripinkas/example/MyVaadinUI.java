package cz.jiripinkas.example;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.domain.Basket;
import cz.jiripinkas.example.view.BasketView;
import cz.jiripinkas.example.view.HomeView;
import cz.jiripinkas.example.view.ItemDetailView;
import cz.jiripinkas.example.view.ItemFormView;
import cz.jiripinkas.example.view.ItemsView;

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

   @Override
   protected void init(VaadinRequest request) {
      navigator = new Navigator(this, this);
      navigator.addView(HOME_VIEW, homeView);
      navigator.addView(ITEMS_VIEW, itemsView);
      navigator.addView(ITEM_DETAIL_VIEW, itemDetailView);
      navigator.addView(ITEM_FORM_VIEW, itemFormView);
      navigator.addView(BASKET_VIEW, basketView);
      basket = new Basket();
   }

   public Basket getBasket() {
      return basket;
   }
}
