package com.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query(value =" select * from product p where p.categoryId = ?", nativeQuery = true)
	public List<Product> retriveProductsBasedOnCategoryId(Integer id);
	
	@Query(value =" select * from product q where q.productName =?", nativeQuery = true)
	public List<Product> retriveProductsBasedOnProductName(String name);
	
	@Query(value =" select * from product a where a.productId =?", nativeQuery = true)
	public Product retriveProductsBasedOnProductId(Integer id);

}
