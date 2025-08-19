package com.order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
	
	public List<Orders> findByEmail(String email);

}
