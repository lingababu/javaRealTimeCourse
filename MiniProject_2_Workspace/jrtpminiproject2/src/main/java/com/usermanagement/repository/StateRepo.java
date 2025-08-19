package com.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.entity.State;

public interface StateRepo extends JpaRepository<State, Integer> {
	
	public List<State> findByCountryCountryId(Integer countryId);
}
