package com.product.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.CategoryDto;
import com.product.entity.Categories;
import com.product.repo.CategoryRepo;
import com.product.serviceinterface.CategoryServiceInterface;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public boolean saveCategory(Categories categories) {

		Categories savedData = categoryRepo.save(categories);

		return savedData.getCategoryId() != null;
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Categories> retriveCategoryName = categoryRepo.findAll();

		if (retriveCategoryName.isEmpty()) {

			return null;
		}

		List<CategoryDto> categoryDtoList = new ArrayList<>();

		BeanUtils.copyProperties(retriveCategoryName, categoryDtoList);

		return categoryDtoList;
	}

}
