package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
