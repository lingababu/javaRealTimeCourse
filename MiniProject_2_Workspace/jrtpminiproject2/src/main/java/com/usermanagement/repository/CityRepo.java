package com.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {
	
	public List<City> findByStateStateId(Integer stateId);

}
