package cz.jiripinkas.example.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

import cz.jiripinkas.example.MyVaadinUI;
import cz.jiripinkas.example.annotation.VaadinComponent;
import cz.jiripinkas.example.dto.ItemDto;
import cz.jiripinkas.example.layout.CustomView;
import cz.jiripinkas.example.service.ItemService;

@VaadinComponent
public class ItemsView extends CustomView {

	@Autowired
	private ItemService itemService;
	private Table table;

	public ItemsView() {
		super("Item list");
		table = new Table();
		table.setSelectable(true);
		table.setSizeFull();
		mainLayout.addComponent(table);

		table.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.isDoubleClick()) {
					int id = Integer.parseInt(event.getItemId().toString());
					UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.ITEM_DETAIL_VIEW + "/" + id);
				}
			}
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		BeanContainer<Integer, ItemDto> container = new BeanContainer<Integer, ItemDto>(ItemDto.class);
		container.setBeanIdProperty("id");
		container.addAll(itemService.findAll());
		table.setContainerDataSource(container);
		table.setVisibleColumns("name", "price");
	}

}
