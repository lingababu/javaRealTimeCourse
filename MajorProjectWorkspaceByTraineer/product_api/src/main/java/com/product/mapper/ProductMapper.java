package com.product.mapper;

import org.modelmapper.ModelMapper;

import com.product.dto.ProductDto;
import com.product.entity.Products;

public class ProductMapper {

	public static final ModelMapper mapper = new ModelMapper();

	public static ProductDto convertToDto(Products products) {

		return mapper.map(products, ProductDto.class);
	}

	public static Products convertToProductEntity(ProductDto productDto) {

		return mapper.map(productDto, Products.class);
	}

}
