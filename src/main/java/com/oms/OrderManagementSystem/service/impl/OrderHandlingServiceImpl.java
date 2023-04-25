package com.oms.OrderManagementSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.OrderManagementSystem.common.constant.OmsConstants;
import com.oms.OrderManagementSystem.dto.OrderDTO;
import com.oms.OrderManagementSystem.dto.VendorDTO;
import com.oms.OrderManagementSystem.entity.Order;
import com.oms.OrderManagementSystem.service.OrderHandlingService;
import com.oms.OrderManagementSystem.service.impl.database.OrderService;
import com.oms.OrderManagementSystem.service.impl.database.ProductService;
import com.oms.OrderManagementSystem.service.impl.database.VendorService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderHandlingServiceImpl implements OrderHandlingService{

	@Autowired
	ProductService productService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	OrderService orderService;
	
	@Override
	public void addNewOrder(@NonNull OrderDTO orderDTO) {
		
		log.info("Received request to add new order, order --> {}",orderDTO);
		
		orderDTO.getOrderProducts().forEach(orderProduct -> {
			
			log.debug("Proceeding to save details for PO with information --> {}",orderProduct);
			
			var productId = productService.fetchOrSaveProductDetails(orderProduct.getProduct());
			List<Long> vendorIDs = fetchVendorIdList(orderProduct.getVendorList());
			
			saveOrderDetails(orderDTO,productId,vendorIDs);
			
		});
		
	}
	
	@Override
	public void updateExistingOrder(@NonNull OrderDTO orderDTO, @NonNull Long existingLoadId) {
		
		log.info("Received request to update existing order, order id --> {}, new details --> {}",existingLoadId, orderDTO);
		if( Boolean.TRUE.equals(orderService.findIfOrderIdExists(existingLoadId)) ) {
			
			log.info("Proceeding to delete existing order information and save updated details");
			deleteExistingOrder(existingLoadId);
			
		} else {
			
			log.info("Existing order details not found, treating request as fresh order");
		}
		
		orderDTO.setId(existingLoadId);
		addNewOrder(orderDTO);
		
	}
	
	@Override
	public void deleteExistingOrder(@NonNull Long orderID) {
		
		log.info("Received request to delete existing order, order id --> {}",orderID);
		orderService.deleteExistingOrder(orderID);
		
	}

	private void saveOrderDetails(OrderDTO orderDTO, Long productId, List<Long> vendorIDs) {
		
		vendorIDs.forEach(vendorId -> {
			var orderEntity = Order.builder()
					.id(orderDTO.getId())
					.description(orderDTO.getDescription())
					.productId(productId)
					.vendorId(vendorId)
					.lastChangeUserId(OmsConstants.OMS_SERVICE)
					.build();
			orderService.saveNewOrder(orderEntity);
		});
		
	}

	private List<Long> fetchVendorIdList(List<VendorDTO> vendorList) {
		
		List<Long> vendorIdList = new ArrayList<>();
		vendorList.forEach(vendor -> {
			vendorIdList.add(vendorService.fetchOrSaveVendorDetails(vendor));
		});
		
		return vendorIdList;
	}
}
