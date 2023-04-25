package com.oms.OrderManagementSystem.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductsDTO {

	ProductDTO product;
	Long quantity;
	List<VendorDTO> VendorList;
	
}