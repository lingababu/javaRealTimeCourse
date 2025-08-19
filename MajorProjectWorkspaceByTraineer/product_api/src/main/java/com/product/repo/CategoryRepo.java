package com.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Categories;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {

}
