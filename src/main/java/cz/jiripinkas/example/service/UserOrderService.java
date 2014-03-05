package cz.jiripinkas.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.entity.UserOrder;
import cz.jiripinkas.example.repository.UserOrderRepository;

@Service
@Transactional
public class UserOrderService {

	@Autowired
	private UserOrderRepository userOrderRepository;

	public UserOrder save(UserOrder userOrder) {
		return userOrderRepository.save(userOrder);
	}

	public UserOrder findOne(int userOrderId) {
		return userOrderRepository.findOne(userOrderId);
	}

	public List<UserOrder> findAll() {
		return userOrderRepository.findAllFetch();
	}

}