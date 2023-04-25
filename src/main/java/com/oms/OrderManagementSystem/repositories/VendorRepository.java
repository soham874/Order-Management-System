package com.oms.OrderManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.OrderManagementSystem.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

}