package com.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByEmail(String email);

}
