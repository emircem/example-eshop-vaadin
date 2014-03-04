package cz.jiripinkas.example.view;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;

import cz.jiripinkas.example.MyVaadinUI;
import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.component.OrderForm;
import cz.jiripinkas.example.dto.ItemDto;
import cz.jiripinkas.example.entity.Item;
import cz.jiripinkas.example.service.ItemService;

@VaadinComponent
public class ItemDetailView extends MenuBarView {

   @Autowired
   private ItemService itemService;

   private Label labelName;
   private Label labelPrice;
   private Label labelDescription;
   private OrderForm orderForm;

   private ItemDto itemDto;

   @Autowired
   private Mapper mapper;

   public ItemDetailView() {
      labelName = new Label();
      labelPrice = new Label();
      labelDescription = new Label();
      orderForm = new OrderForm() {

         @Override
         public void onSubmit() {
            MyVaadinUI myVaadinUI = (MyVaadinUI) MyVaadinUI.getCurrent();
            // TODO REFACTOROVAT!
            Item item = mapper.map(itemDto, Item.class);
            myVaadinUI.getBasket().add(item, orderForm.getQuantity());
            MyVaadinUI.getCurrent().getNavigator().navigateTo(MyVaadinUI.BASKET_VIEW);
         }
      };
      mainLayout.addComponents(labelName, labelPrice, labelDescription, orderForm);
   }

   @Override
   public void enter(ViewChangeEvent event) {
      String parameters = event.getParameters();
      int id = Integer.parseInt(parameters);
      itemDto = itemService.findOne(id);
      labelName.setValue(itemDto.getName());
      labelPrice.setValue("Price: " + itemDto.getPrice());
      labelDescription.setValue(itemDto.getDescription());
      orderForm.init();
   }

}
