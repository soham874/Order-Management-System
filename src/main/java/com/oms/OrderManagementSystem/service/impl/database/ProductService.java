package com.oms.OrderManagementSystem.service.impl.database;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.OrderManagementSystem.common.constant.OmsConstants;
import com.oms.OrderManagementSystem.dto.ProductDTO;
import com.oms.OrderManagementSystem.entity.Product;
import com.oms.OrderManagementSystem.repositories.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Long fetchOrSaveProductDetails(ProductDTO productDTO) {
		
		Optional<Product> previousProductDetails = productRepository.findByIdAndDescription(productDTO.getId(), productDTO.getDescription());
		
		if( previousProductDetails.isPresent() ) {
			log.info("Product information already existing, hence no action taken");
		}else {
			log.info("Requested product not found, saving new product details");
			productRepository.save(Product.builder()
					.description(productDTO.getDescription())
					.id(productDTO.getId())
					.lastChangeUserId(OmsConstants.OMS_SERVICE)
					.build());
		}
		
		return productDTO.getId();
	}
}
