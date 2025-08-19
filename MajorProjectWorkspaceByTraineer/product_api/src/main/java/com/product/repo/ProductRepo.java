package com.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {
	
	public List<Products> findByCategoriesCategoryId(Integer id);
	
	public List<Products> findByProductNameContaining(String name);
}
