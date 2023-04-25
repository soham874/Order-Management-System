package com.oms.OrderManagementSystem.service.impl;

import org.springframework.stereotype.Service;

import com.oms.OrderManagementSystem.dto.OrderDTO;
import com.oms.OrderManagementSystem.service.OrderHandlingService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderHandlingServiceImpl implements OrderHandlingService{

	@Override
	public void addNewOrder(@NonNull OrderDTO orderDTO) {
		
	};
}
