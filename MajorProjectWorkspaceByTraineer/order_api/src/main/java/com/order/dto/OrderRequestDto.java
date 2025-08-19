package com.order.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderRequestDto {

	@JsonProperty("customer")
	private CustomerDto customer;

	@JsonProperty("address")
	private AddressDto address;

	@JsonProperty("order")
	private OrderDto order;

	@JsonProperty("orderItems")
	private List<OrderItemDto> orderItems;

}
