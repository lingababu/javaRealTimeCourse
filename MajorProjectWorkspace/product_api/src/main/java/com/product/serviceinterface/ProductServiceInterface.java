package com.product.serviceinterface;

import java.util.List;

import com.product.dto.ProductDto;

public interface ProductServiceInterface {

	public boolean saveProducts(ProductDto productDto);

	public List<ProductDto> getProductDetailsBasedOnCategoryId(Integer id);

	public List<ProductDto> getProductNames(String name);

	public ProductDto getProductsById(Integer id);

}
