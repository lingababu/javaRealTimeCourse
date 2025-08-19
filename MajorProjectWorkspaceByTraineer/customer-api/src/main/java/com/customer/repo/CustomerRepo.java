package com.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public Customer findByEmailAndPassword(String email, String password);
	
	public Customer findByEmail(String email);

}
