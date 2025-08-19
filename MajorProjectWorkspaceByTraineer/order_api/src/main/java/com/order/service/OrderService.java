package com.order.service;

import java.util.List;

import com.order.dto.OrderDto;
import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;

public interface OrderService {

	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) throws Exception;

	public OrderResponseDto updateOrder(OrderDto orderDto);

	public List<OrderDto> retriveOrderDetailsBy(String email);

}
