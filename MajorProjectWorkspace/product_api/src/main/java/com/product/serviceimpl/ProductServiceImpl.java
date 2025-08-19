package com.product.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductDto;
import com.product.entity.Categories;
import com.product.entity.Product;
import com.product.repo.CategoryRepo;
import com.product.repo.ProductRepo;
import com.product.serviceinterface.ProductServiceInterface;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<ProductDto> getProductDetailsBasedOnCategoryId(Integer id) {

		List<Product> retriveProductsBasedOnCategoryId = productRepo.retriveProductsBasedOnCategoryId(id);

		if (retriveProductsBasedOnCategoryId.isEmpty()) {

			return null;
		}

		List<ProductDto> productDtoList = new ArrayList<>();

		BeanUtils.copyProperties(retriveProductsBasedOnCategoryId, productDtoList);

		return productDtoList;
	}

	@Override
	public boolean saveProducts(ProductDto productDto) {
		Product product = new Product();

		BeanUtils.copyProperties(productDto, product);

		Optional<Categories> optionalCategory = categoryRepo.findById(productDto.getCategoryId());

		if (optionalCategory.isEmpty()) {
			throw new RuntimeException("Invalid category ID: " + productDto.getCategoryId());
		}

		product.setCategory(optionalCategory.get());

		Product savedProduct = productRepo.save(product);

		return savedProduct.getProductId() != null;
	}

	@Override
	public List<ProductDto> getProductNames(String name) {

		List<Product> retriveProductsBasedOnProductName = productRepo.retriveProductsBasedOnProductName(name);

		if (retriveProductsBasedOnProductName.isEmpty()) {
			return null;
		}

		List<ProductDto> productNamesList = new ArrayList<>();

		BeanUtils.copyProperties(retriveProductsBasedOnProductName, productNamesList);

		return productNamesList;
	}

	@Override
	public ProductDto getProductsById(Integer id) {

		Product retriveProductsBasedOnCategoryId = productRepo.retriveProductsBasedOnProductId(id);

		if (retriveProductsBasedOnCategoryId == null) {

			return null;
		}
		
		ProductDto productDto = new ProductDto();
		
		BeanUtils.copyProperties(retriveProductsBasedOnCategoryId, productDto);

		return productDto;
	}

}
