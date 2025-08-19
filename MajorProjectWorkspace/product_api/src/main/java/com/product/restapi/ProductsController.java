package com.product.restapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductDto;
import com.product.entity.Product;
import com.product.serviceimpl.ProductServiceImpl;

@RestController
public class ProductsController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping(value = "/getProducts/{id}")
	public ResponseEntity<List<Product>> getProducts(@RequestParam Long id) {

		List<Product> productDetailsBasedOnCategoryId = productServiceImpl.getProductDetailsBasedOnCategoryId(id);

		if (productDetailsBasedOnCategoryId.isEmpty()) {

			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Product>>(productDetailsBasedOnCategoryId, HttpStatus.OK);
	}

	@PostMapping(value = "/saveProducts")
	public ResponseEntity<String> saveProducts(@RequestBody ProductDto productDto) {

		boolean saveProducts = productServiceImpl.saveProducts(productDto);

		if (saveProducts) {

			return new ResponseEntity<String>("Products saved successfully.", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Products data not saved.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/getProductsOnProductName/{name}")
	public ResponseEntity<List<Product>> getProductsBasedOnName(@RequestParam String name) {

		List<Product> productNames = productServiceImpl.getProductNames(name);

		if (productNames.isEmpty()) {

			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Product>>(productNames, HttpStatus.OK);

	}

	@GetMapping(value = "/getProductsBasedOnPId/{id}")
	public ResponseEntity<List<Product>> getProductBasedOnProductId(Long id) {

		List<Product> productsById = productServiceImpl.getProductsById(id);

		if (productsById.isEmpty()) {

			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Product>>(productsById, HttpStatus.OK);

	}
}
