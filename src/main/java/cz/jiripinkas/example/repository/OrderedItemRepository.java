package cz.jiripinkas.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.example.entity.OrderedItem;

public interface OrderedItemRepository extends
		JpaRepository<OrderedItem, Integer> {

}