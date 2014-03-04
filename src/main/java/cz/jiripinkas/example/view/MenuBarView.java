package cz.jiripinkas.example.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.example.MyVaadinUI;

public abstract class MenuBarView extends CustomComponent implements View {

   protected VerticalLayout mainLayout;

   MenuBarView() {
      mainLayout = new VerticalLayout();
      setCompositionRoot(mainLayout);
      MenuBar menuBar = new MenuBar();
      mainLayout.addComponent(menuBar);
      menuBar.setWidth("100%");
      MenuItem mainItem = menuBar.addItem("Main", null);
      mainItem.addItem("Home", new MenuBar.Command() {
         @Override
         public void menuSelected(MenuItem selectedItem) {
            UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.HOME_VIEW);
         }
      });
      mainItem.addItem("Items", new MenuBar.Command() {
         @Override
         public void menuSelected(MenuItem selectedItem) {
            UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEMS_VIEW);
         }
      });
      mainItem.addItem("Add item", new MenuBar.Command() {
         @Override
         public void menuSelected(MenuItem selectedItem) {
            UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEM_FORM_VIEW);
         }
      });
      mainItem.addItem("Basket", new MenuBar.Command() {
         @Override
         public void menuSelected(MenuItem selectedItem) {
            UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.BASKET_VIEW);
         }
      });
   }

}