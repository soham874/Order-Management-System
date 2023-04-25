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
	
	public void deleteExistingOrder(Long orderId) {
		log.info("Deleteing order related to existing order number --> {}",orderId);
		orderRepository.deleteById(orderId);
	}
	
	public boolean findIfOrderIdExists(Long orderId) {
		var orderFound = orderRepository.findAllById(orderId);
		
		if( Boolean.FALSE.equals(orderFound) ) {
			log.warn("Exisitng order information not found for id --> {} although expected", orderId);
			return false;
		}
		
		log.info("Existing order information found");
		return true;
	}
}
