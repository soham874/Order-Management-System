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
		
		
		orderDTO.getOrderProducts().forEach(orderProduct -> {
			
			log.debug("Proceeding to save details for PO with information --> {}",orderProduct);
			
			var productId = productService.fetchOrSaveProductDetails(orderProduct.getProduct());
			List<Long> vendorIDs = fetchVendorIdList(orderProduct.getVendorList());
			
			saveOrderDetails(orderDTO,productId,vendorIDs);
			
		});
		
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
