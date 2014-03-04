package cz.jiripinkas.example.service;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.domain.Basket;
import cz.jiripinkas.example.entity.OrderedItem;
import cz.jiripinkas.example.entity.UserOrder;

@Service
@Transactional
public class BasketService {

   @Autowired
   private UserOrderService userOrderService;

   @Autowired
   private OrderedItemService orderedItemService;

   public void save(Basket basket, UserOrder userOrder) {
      userOrder.setOrderDate(new Date());
      userOrder = userOrderService.save(userOrder);
      Collection<OrderedItem> items = basket.getItems();
      for (OrderedItem orderedItem : items) {
         orderedItem.setUserOrder(userOrder);
         orderedItemService.save(orderedItem);
      }
      basket.clear();
   }

}