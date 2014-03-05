package cz.jiripinkas.example.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.domain.Basket;
import cz.jiripinkas.example.entity.Item;
import cz.jiripinkas.example.entity.UserOrder;
import cz.jiripinkas.example.repository.ItemRepository;

@Service
@Transactional
public class DbInitService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BasketService basketService;

	@PostConstruct
	public void init() {
		System.out.println("*** START INIT DATABASE ***");

		Item javaEbook = new Item();
		javaEbook.setName("Java in 21 days");
		javaEbook.setDescription("EBook");
		javaEbook.setPrice(500);
		itemRepository.save(javaEbook);

		Item javaCup = new Item();
		javaCup.setName("Java cup");
		javaCup.setDescription("Coffee cup");
		javaCup.setPrice(100);
		itemRepository.save(javaCup);

		Item javaTShirt = new Item();
		javaTShirt.setName("Java t-shirt");
		javaTShirt.setDescription("T-shirts for all Java programmers");
		javaTShirt.setPrice(500);
		itemRepository.save(javaTShirt);

		UserOrder userOrder = new UserOrder();
		userOrder.setName("Jirka Pinkas");
		userOrder.setCity("Hradec Králové");
		userOrder.setStreet("Šantrochova 424/3");
		userOrder.setZip("500 11");
		Basket basket = new Basket();
		basket.add(javaEbook, 1);
		basket.add(javaCup, 1);
		basketService.save(basket, userOrder);

		System.out.println("*** FINISH INIT DATABASE ***");
	}

}