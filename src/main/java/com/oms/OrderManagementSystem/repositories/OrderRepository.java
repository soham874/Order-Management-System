package com.oms.OrderManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.OrderManagementSystem.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	void deleteById(Long id);
}