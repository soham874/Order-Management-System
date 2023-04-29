package com.oms.ordermanagementsystem.service;

import com.oms.ordermanagementsystem.dto.OrderDTO;

import lombok.NonNull;

public interface OrderHandlingService {

	void addNewOrder(@NonNull OrderDTO orderDTO);
	
	void deleteExistingOrder(@NonNull Long orderID);
	
	void updateExistingOrder(@NonNull OrderDTO orderDTO, @NonNull Long existingLoadId);
}
