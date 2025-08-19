package com.product.productserviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.product.dto.CategoryDto;
import com.product.dto.ProductDto;
import com.product.entity.Categories;
import com.product.entity.Products;
import com.product.mapper.CategoryMapper;
import com.product.mapper.ProductMapper;
import com.product.repo.CategoryRepo;
import com.product.repo.ProductRepo;
import com.product.serviceinterface.ProductServiceInterface;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	@Override
	@Cacheable(value ="categories")
	public List<CategoryDto> getAllCategories() {

		List<Categories> allCategoriesList = categoryRepo.findAll();

		List<CategoryDto> categoriesList = allCategoriesList.stream().map(CategoryMapper::convertToDto)
				.collect(Collectors.toList());

		return categoriesList;
	}

	@Override
	public List<ProductDto> getProductsBasedOnCategoryId(Integer id) {

		List<Products> byCategoriesCategoryId = productRepo.findByCategoriesCategoryId(id);

		List<ProductDto> productsList = byCategoriesCategoryId.stream().map(ProductMapper::convertToDto)
				.collect(Collectors.toList());

		return productsList;
	}

	@Override
	public List<ProductDto> getProductsBasedOnProductName(String name) {

		List<Products> byProductNameContaing = productRepo.findByProductNameContaining(name);

		List<ProductDto> namesList = byProductNameContaing.stream().map(ProductMapper::convertToDto)
				.collect(Collectors.toList());

		return namesList;
	}

	@Override
	public ProductDto getProductsBasedOnProductId(Integer Id) {

		return productRepo.findById(Id).map(ProductMapper::convertToDto).orElse(null);
	}

}
