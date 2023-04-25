package com.oms.OrderManagementSystem.service.impl.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.OrderManagementSystem.entity.Order;
import com.oms.OrderManagementSystem.repositories.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public void saveNewOrder(Order order) {
		
		log.info("Saving new order --> {}",order);
		orderRepository.save(order);
	}
}
