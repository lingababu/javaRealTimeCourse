package com.product.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryDto implements Serializable {

	private Integer categoryId;

	private String name;

}
