package com.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

	public Optional<OrderItem> findByOrdersEmail(String email);

}
