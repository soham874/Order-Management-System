package com.oms.ordermanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.ordermanagementsystem.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

	Optional<Vendor> findByIdAndName(Long id, String name);
}