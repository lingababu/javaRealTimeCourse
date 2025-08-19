package com.product.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.product.apiresponse.ApiResponse;
import com.product.dto.CategoryDto;
import com.product.dto.ProductDto;
import com.product.serviceinterface.ProductServiceInterface;

@RestController
@CrossOrigin
public class ProductRestcontroller {

	@Autowired
	private ProductServiceInterface productServiceInterface;

	@GetMapping(value = "/getCategories")
	public ResponseEntity<ApiResponse<List<CategoryDto>>> getAllCategories() {

		ApiResponse<List<CategoryDto>> response = new ApiResponse<>();

		List<CategoryDto> allCategories = productServiceInterface.getAllCategories();

		if (allCategories.isEmpty()) {

			response.setData(null);

			response.setMessage("Failed to fetch Data");

			response.setStatus(204);

			return new ResponseEntity<ApiResponse<List<CategoryDto>>>(HttpStatus.NO_CONTENT);
		} else {

			response.setData(allCategories);

			response.setMessage("Fetched all categories");

			response.setStatus(200);

			return new ResponseEntity<ApiResponse<List<CategoryDto>>>(response, HttpStatus.OK);
		}

	}

	@GetMapping("/ProductsByCID/{id}")
	public ResponseEntity<ApiResponse<List<ProductDto>>> getProductBasedOnCategoryId(@PathVariable Integer id) {

		ApiResponse<List<ProductDto>> response = new ApiResponse<>();

		List<ProductDto> productsBasedOnCategoryId = productServiceInterface.getProductsBasedOnCategoryId(id);

		if (productsBasedOnCategoryId.isEmpty()) {

			response.setData(null);

			response.setMessage("Failed to fetch products data.");

			response.setStatus(204);

			return new ResponseEntity<ApiResponse<List<ProductDto>>>(HttpStatus.NO_CONTENT);

		} else {
			response.setData(productsBasedOnCategoryId);

			response.setMessage("Fetched all products based on category id.");

			response.setStatus(200);

			return new ResponseEntity<ApiResponse<List<ProductDto>>>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/productsByName/{name}")
	public ResponseEntity<ApiResponse<List<ProductDto>>> getProductsBasedOnNames(@PathVariable String name) {

		ApiResponse<List<ProductDto>> response = new ApiResponse<>();

		List<ProductDto> namesList = productServiceInterface.getProductsBasedOnProductName(name);

		if (namesList.isEmpty()) {

			response.setData(null);

			response.setMessage("Failed to fetch data");

			response.setStatus(204);

			return new ResponseEntity<ApiResponse<List<ProductDto>>>(HttpStatus.NO_CONTENT);

		} else {

			response.setData(namesList);

			response.setMessage("Fetched all products based on names.");

			response.setStatus(200);

			return new ResponseEntity<ApiResponse<List<ProductDto>>>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/productsById/{id}")
	public ResponseEntity<ApiResponse<ProductDto>> getProductsBasedOnPID(@PathVariable Integer id) {

		ApiResponse<ProductDto> response = new ApiResponse<>();

		ProductDto productsList = productServiceInterface.getProductsBasedOnProductId(id);

		if (productsList == null) {

			response.setData(null);

			response.setMessage("failed to fetch data");

			response.setStatus(204);

			return new ResponseEntity<ApiResponse<ProductDto>>(HttpStatus.NO_CONTENT);
		} else {

			response.setData(productsList);

			response.setMessage("Fetched  product.");

			response.setStatus(200);

			return new ResponseEntity<ApiResponse<ProductDto>>(response, HttpStatus.OK);
		}

	}

}
