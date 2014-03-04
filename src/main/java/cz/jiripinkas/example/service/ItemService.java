package cz.jiripinkas.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.dto.ItemDto;
import cz.jiripinkas.example.entity.Item;
import cz.jiripinkas.example.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

   @Autowired
   private ItemRepository itemRepository;
   
   @Autowired
   private Mapper mapper;

   public Item save(ItemDto itemDto) {
      Item item = mapper.map(itemDto, Item.class);
      return itemRepository.save(item);
   }

   public ItemDto findOne(int id) {
      Item item = itemRepository.findOne(id);
      return mapper.map(item, ItemDto.class);
   }

   public List<ItemDto> findAll() {
      List<ItemDto> result = new ArrayList<ItemDto>();
      List<Item> list = itemRepository.findAll();
      for (Item item : list) {
         result.add(mapper.map(item, ItemDto.class));
      }
      return result;
   }

   public void remove(int id) {
      itemRepository.delete(id);
   }

}