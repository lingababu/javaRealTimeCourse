package com.product.serviceinterface;

import java.util.List;

import com.product.dto.CategoryDto;
import com.product.dto.ProductDto;

public interface ProductServiceInterface {
	
	public List<CategoryDto> getAllCategories();
	
	public List<ProductDto>  getProductsBasedOnCategoryId(Integer id);
	
	public List<ProductDto> getProductsBasedOnProductName(String name);
	
	public ProductDto getProductsBasedOnProductId(Integer Id);

}
