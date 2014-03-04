package cz.jiripinkas.example.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.dto.ItemDto;
import cz.jiripinkas.example.form.ItemForm;
import cz.jiripinkas.example.service.ItemService;

@VaadinComponent
public class ItemFormView extends MenuBarView {

   @Autowired
   private ItemForm itemForm;

   @Autowired
   private ItemService itemService;

   @PostConstruct
   public void init() {
      mainLayout.addComponent(itemForm);
   }

   @Override
   public void enter(ViewChangeEvent event) {
      ItemDto itemDto;
      if (event.getParameters().isEmpty()) {
         // empty form
         itemDto = new ItemDto();
      } else {
         int id = Integer.parseInt(event.getParameters().toString());
         itemDto = itemService.findOne(id);
      }
      itemForm.setComponent(itemDto, ItemDto.class);
   }

}
