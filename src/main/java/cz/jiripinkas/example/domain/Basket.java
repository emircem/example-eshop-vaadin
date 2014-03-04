package cz.jiripinkas.example.domain;

import java.util.Collection;
import java.util.HashMap;

import cz.jiripinkas.example.entity.Item;
import cz.jiripinkas.example.entity.OrderedItem;

public class Basket {

	private HashMap<Integer, OrderedItem> items = new HashMap<Integer, OrderedItem>();

	public void add(Item item, int quantity) {
		int itemId = item.getId();
		if (items.containsKey(itemId)) {
			OrderedItem orderedItem = items.get(itemId);
			orderedItem.setQuantity(orderedItem.getQuantity() + quantity);
		} else {
			OrderedItem orderedItem = new OrderedItem();
			orderedItem.setItem(item);
			orderedItem.setQuantity(quantity);
			items.put(item.getId(), orderedItem);
		}
	}

	public Collection<OrderedItem> getItems() {
		return items.values();
	}

	public void remove(int itemId) {
		items.remove(itemId);
	}

	public void clear() {
		items.clear();
	}
}