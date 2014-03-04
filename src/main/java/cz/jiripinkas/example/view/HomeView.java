package cz.jiripinkas.example.view;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;

import cz.jiripinkas.example.annotation.VaadinComponent;

@VaadinComponent
public class HomeView extends MenuBarView {
   
   public HomeView() {
      Label label = new Label("EShop example using Vaadin");
      mainLayout.addComponent(label);
   }

   @Override
   public void enter(ViewChangeEvent event) {
   }

}
