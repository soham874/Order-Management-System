package com.oms.ordermanagementsystem.controller;

import com.oms.ordermanagementsystem.service.OrderHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oms.ordermanagementsystem.common.constant.OmsConstants;
import com.oms.ordermanagementsystem.dto.OrderDTO;

import lombok.NonNull;

@RequestMapping(value = "/v1/oms")
@RestController
public class OrderManagementController {
	
	@Autowired
	OrderHandlingService orderHandlingServiceImpl;

	@PostMapping("/add-order")
	public String addNewOrder(@RequestBody @NonNull OrderDTO orderDTO) {
		
		orderHandlingServiceImpl.addNewOrder(orderDTO);
		return OmsConstants.SUCCESS;
	}
	
	@PostMapping("/delete-order")
	public String addNewOrder(@RequestBody @NonNull Long orderID) {
		
		orderHandlingServiceImpl.deleteExistingOrder(orderID);
		return OmsConstants.SUCCESS;
	}
	
	@PostMapping("/edit-order")
	public String updateExistingOrder(@RequestBody @NonNull OrderDTO orderDTO, @RequestParam @NonNull Long existingOrderId) {
		
		orderHandlingServiceImpl.updateExistingOrder(orderDTO,existingOrderId);
		return OmsConstants.SUCCESS;
	}
}
