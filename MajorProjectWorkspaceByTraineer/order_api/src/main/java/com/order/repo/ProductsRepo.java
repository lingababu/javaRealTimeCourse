package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

}
