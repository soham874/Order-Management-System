package com.oms.OrderManagementSystem.service;

import com.oms.OrderManagementSystem.dto.OrderDTO;

import lombok.NonNull;

public interface OrderHandlingService {

	void addNewOrder(@NonNull OrderDTO orderDTO);
}
