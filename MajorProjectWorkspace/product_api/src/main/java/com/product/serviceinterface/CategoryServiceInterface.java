package com.product.serviceinterface;

import java.util.List;

import com.product.dto.CategoryDto;
import com.product.entity.Categories;

public interface CategoryServiceInterface {
	
	public boolean saveCategory(Categories categories);
	
	public List<CategoryDto> getAllCategory();

}
