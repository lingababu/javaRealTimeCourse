package com.product.mapper;

import org.modelmapper.ModelMapper;

import com.product.dto.CategoryDto;
import com.product.entity.Categories;

public class CategoryMapper {

	public static final ModelMapper mapper = new ModelMapper();

	public static CategoryDto convertToDto(Categories categories) {

		return mapper.map(categories, CategoryDto.class);
	}

	public static Categories convertToEntity(CategoryDto categoryDto) {

		return mapper.map(categoryDto, Categories.class);
	}

}
