package cz.jiripinkas.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.entity.OrderedItem;
import cz.jiripinkas.example.repository.OrderedItemRepository;

@Service
@Transactional
public class OrderedItemService {

   @Autowired
   private OrderedItemRepository orderedItemRepository;

   public OrderedItem save(OrderedItem orderedItem) {
      return orderedItemRepository.save(orderedItem);
   }

   public OrderedItem findOne(int orderedItemId) {
      return orderedItemRepository.findOne(orderedItemId);
   }

}