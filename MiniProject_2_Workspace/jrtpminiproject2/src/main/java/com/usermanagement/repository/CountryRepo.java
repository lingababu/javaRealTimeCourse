package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
	
	
}
