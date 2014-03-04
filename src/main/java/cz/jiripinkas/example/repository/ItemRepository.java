package cz.jiripinkas.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.example.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}