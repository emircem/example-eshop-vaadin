package cz.jiripinkas.example.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.dto.ItemDto;

@Service
@Transactional
public class DbInitService {

   @Autowired
   private ItemService ItemDtoService;
   
   @Autowired
   private Mapper mapper;
   
   @PostConstruct
   public void init() {
      System.out.println("*** START INIT DATABASE ***");
      {
         ItemDto ItemDto = new ItemDto();
         ItemDto.setName("Java in 21 days");
         ItemDto.setDescription("EBook");
         ItemDto.setPrice(500);
         ItemDtoService.save(ItemDto);
      }
      {
         ItemDto ItemDto = new ItemDto();
         ItemDto.setName("Java cup");
         ItemDto.setDescription("Coffee cup");
         ItemDto.setPrice(100);
         ItemDtoService.save(ItemDto);
      }
      {
         ItemDto ItemDto = new ItemDto();
         ItemDto.setName("Java t-shirt");
         ItemDto.setDescription("T-shirts for all Java programmers");
         ItemDto.setPrice(500);
         ItemDtoService.save(ItemDto);
      }
      {
         ItemDto ItemDto = new ItemDto();
         ItemDto.setName("Professional Java consulting");
         ItemDto.setDescription("per manhour");
         ItemDto.setPrice(800);
         ItemDtoService.save(ItemDto);
      }
      {
         ItemDto ItemDto = new ItemDto();
         ItemDto.setName("Professional Java training");
         ItemDto.setDescription("per manday");
         ItemDto.setPrice(800);
         ItemDtoService.save(ItemDto);
      }
      System.out.println("*** FINISH INIT DATABASE ***");
   }

}