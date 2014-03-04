package cz.jiripinkas.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.jiripinkas.example.entity.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

   @Query("select distinct o from UserOrder o left join fetch o.orderedItems oi join fetch oi.item")
   List<UserOrder> findAllFetch();

   @Query("select distinct o from UserOrder o left join fetch o.orderedItems oi join fetch oi.item where o.id = :id")
   UserOrder findOneFetch(@Param("id") int id);

}