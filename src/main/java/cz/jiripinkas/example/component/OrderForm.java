package cz.jiripinkas.example.component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public abstract class OrderForm extends CustomComponent {

   private Label label;
   private TextField textField;
   private Button button;

   public OrderForm() {
      label = new Label("order items:");
      textField = new TextField();
      button = new Button("order now");
      HorizontalLayout layout = new HorizontalLayout(label, textField, button);
      layout.setSpacing(true);
      setCompositionRoot(layout);
      button.addClickListener(new ClickListener() {

         @Override
         public void buttonClick(ClickEvent event) {
            onSubmit();
         }
      });
   }

   public abstract void onSubmit();

   public int getQuantity() {
      return Integer.parseInt(textField.getValue());
   }

   public void init() {
      textField.setValue("1");
   }

}
