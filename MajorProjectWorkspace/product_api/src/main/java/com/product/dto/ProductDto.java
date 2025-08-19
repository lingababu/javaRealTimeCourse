package com.product.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {
	
	
		private Integer productId;
		
		private String productName;
		
		private BigDecimal price;
		
		private String description;
		
		private String title;
		
		private Boolean active;
		
		private Integer units_stock;
		
		private String image;
	
		private Integer categoryId;


}
