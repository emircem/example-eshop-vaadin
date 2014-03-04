package cz.jiripinkas.example.view;

import java.util.Collection;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

import cz.jiripinkas.example.MyVaadinUI;
import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.domain.Basket;
import cz.jiripinkas.example.entity.OrderedItem;

@VaadinComponent
public class BasketView extends MenuBarView {

   private Table table;

   public BasketView() {
      table = new Table();
      table.setSizeFull();
      mainLayout.addComponent(table);
   }

   @Override
   public void enter(ViewChangeEvent event) {
      MyVaadinUI myVaadinUI = (MyVaadinUI) UI.getCurrent();
      Basket basket = myVaadinUI.getBasket();
      Collection<OrderedItem> items = basket.getItems();
      IndexedContainer container = new IndexedContainer();
      container.addContainerProperty("name", String.class, null);
      container.addContainerProperty("quantity", Integer.class, null);
      for (OrderedItem orderedItem : items) {
         Item item = container.addItem(orderedItem.getItem().getId());
         Property<String> propertyName = item.getItemProperty("name");
         propertyName.setValue(orderedItem.getItem().getName());
         Property<Integer> propertyQuantity = item.getItemProperty("quantity");
         propertyQuantity.setValue(orderedItem.getQuantity());
      }
      table.setContainerDataSource(container);
   }

}
