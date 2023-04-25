package com.oms.OrderManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.OrderManagementSystem.common.constant.OmsConstants;
import com.oms.OrderManagementSystem.dto.OrderDTO;
import com.oms.OrderManagementSystem.service.impl.OrderHandlingServiceImpl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/v1/oms")
@Slf4j
@RestController
public class OrderManagementController {
	
	@Autowired
	OrderHandlingServiceImpl orderHandlingServiceImpl;

	@PostMapping("/add-order")
	public String addNewOrder(@RequestBody @NonNull OrderDTO orderDTO) {
		log.info("Received request to add new order, order --> {}",orderDTO);
		orderHandlingServiceImpl.addNewOrder(orderDTO);
		return OmsConstants.SUCCESS;
	}
}
