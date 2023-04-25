package com.oms.OrderManagementSystem.service;

import com.oms.OrderManagementSystem.dto.OrderDTO;

import lombok.NonNull;

public interface OrderHandlingService {

	void addNewOrder(@NonNull OrderDTO orderDTO);
	
	void deleteExistingOrder(@NonNull Long orderID);
	
	void updateExistingOrder(@NonNull OrderDTO orderDTO, @NonNull Long existingLoadId);
}
