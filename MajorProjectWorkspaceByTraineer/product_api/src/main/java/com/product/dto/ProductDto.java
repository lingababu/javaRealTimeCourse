package com.product.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductDto {

	private Integer productId;

	private String productName;

	private String description;

	private Integer unitStock;

	private String title;

	private String imageurl;

	private Boolean active;

	private Double price;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
