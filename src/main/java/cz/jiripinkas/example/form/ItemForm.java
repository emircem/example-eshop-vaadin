package cz.jiripinkas.example.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import cz.jiripinkas.example.MyVaadinUI;
import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.component.FormComponent;
import cz.jiripinkas.example.dto.ItemDto;
import cz.jiripinkas.example.service.ItemService;

@VaadinComponent
public class ItemForm extends FormComponent<ItemDto> {

   @Autowired
   private ItemService itemService;

   private TextField name;
   private TextField description;
   private TextField price;

   public ItemForm() {
      super(400, "New Item:");
      name = new TextField("Name:");
      description = new TextField("Description:");
      price = new TextField("Price:");
      central.addComponents(name, description, price);
   }

   @Override
   public void onSave() {
      try {
         ItemDto itemDto = getComponent();
         itemService.save(itemDto);
      } catch (CommitException e) {
         e.printStackTrace();
      }
      UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEMS_VIEW);
   }

   @Override
   public void onCancel() {
      UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEMS_VIEW);
   }

}
