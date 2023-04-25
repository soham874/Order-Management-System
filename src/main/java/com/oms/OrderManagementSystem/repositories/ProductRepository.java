package com.oms.OrderManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oms.OrderManagementSystem.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}