package com.order.dto;

import lombok.Data;

@Data
public class OrderItemDto {

	private Integer orderItemId;

	private String productName;

	private String imageUrl;

	private Integer quantity;

	private double unitPrice;

}
