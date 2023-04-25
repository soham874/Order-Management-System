package com.oms.OrderManagementSystem.service.impl.database;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.OrderManagementSystem.common.constant.OmsConstants;
import com.oms.OrderManagementSystem.dto.VendorDTO;
import com.oms.OrderManagementSystem.entity.Vendor;
import com.oms.OrderManagementSystem.repositories.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorService {
	
	@Autowired
	VendorRepository vendorRepository;

	public Long fetchOrSaveVendorDetails(VendorDTO vendorDTO) {
		
		Optional<Vendor> previousProductDetails = vendorRepository.findByIdAndName(vendorDTO.getId(), vendorDTO.getName());
		
		if( previousProductDetails.isPresent() ) {
			log.info("Vendor information already existing, hence no action taken");
		}else {
			log.info("Requested vendor not found, saving new vendor details");
			vendorRepository.save(Vendor.builder()
					.name(vendorDTO.getName())
					.id(vendorDTO.getId())
					.address(vendorDTO.getAddress())
					.lastChangeUserId(OmsConstants.OMS_SERVICE)
					.build());
		}
		
		return vendorDTO.getId();
	}
}
