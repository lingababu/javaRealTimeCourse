package com.product.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Categories;
import com.product.serviceimpl.CategoryServiceImpl;

@RestController
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@PostMapping(value = "/saveCategories")
	public ResponseEntity<String> saveCategories(@RequestBody Categories categories) {

		boolean saveCategory = categoryServiceImpl.saveCategory(categories);

		if (saveCategory) {

			return new ResponseEntity<String>("Categories saved succesfully.", HttpStatus.CREATED);
		} else
			return new ResponseEntity<String>("Can't save categories data.", HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping(value ="/getCategories")
	public ResponseEntity<List<String>> getCategoryNames(){
		
		List<String> categoryNames = categoryServiceImpl.getCategoryNames();
		
		if(categoryNames.isEmpty()) {
			
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<String>>(categoryNames, HttpStatus.OK);
		
	}

}
