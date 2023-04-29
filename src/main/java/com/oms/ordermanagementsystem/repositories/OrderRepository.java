package com.oms.ordermanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.ordermanagementsystem.entity.Order;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Transactional
	void deleteAllByOrderId(Long orderId);
	
	List<Order> findAllByOrderId(Long orderId);
}