package com.order.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.order.apiresponse.ApiResponse;
import com.order.dto.OrderDto;
import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.service.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/createOrder")
	public ResponseEntity<ApiResponse<OrderResponseDto>> createOrder(@RequestBody OrderRequestDto orderRequestDto)
			throws Exception {

		ApiResponse<OrderResponseDto> response = new ApiResponse<OrderResponseDto>();

		OrderResponseDto order = orderService.createOrder(orderRequestDto);

		if (order != null) {
			response.setData(order);
			response.setMessage("Order created succesfully");
			response.setStatus("OK");
			return new ResponseEntity<ApiResponse<OrderResponseDto>>(response, HttpStatus.CREATED);
		} else {
			response.setData(null);
			response.setMessage("Error occured while creating order");
			response.setStatus("BAD REQUEST");
			return new ResponseEntity<ApiResponse<OrderResponseDto>>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/retriveOrders")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getOrdersList(String email) {

		ApiResponse<List<OrderDto>> response = new ApiResponse<>();

		List<OrderDto> order = orderService.retriveOrderDetailsBy(email);

		if (order.isEmpty()) {
			response.setData(null);
			response.setMessage("No data available");
			response.setStatus("BAD REQUEST");
			return new ResponseEntity<ApiResponse<List<OrderDto>>>(HttpStatus.BAD_REQUEST);
		} else {
			response.setData(order);
			response.setMessage("Data fetched successfully.");
			response.setStatus("OK");
			return new ResponseEntity<ApiResponse<List<OrderDto>>>(response, HttpStatus.OK);
		}

	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<ApiResponse<OrderResponseDto>> updateOrder(OrderDto orderDto) {

		ApiResponse<OrderResponseDto> response = new ApiResponse<>();

		OrderResponseDto data = orderService.updateOrder(orderDto);

		if (data == null) {
			response.setData(null);
			response.setMessage("there is no data to update.");
			response.setStatus("BAD REQUEST");
			return new ResponseEntity<ApiResponse<OrderResponseDto>>(HttpStatus.BAD_REQUEST);
		} else {
			response.setData(data);
			response.setMessage("Data updated successfully");
			response.setStatus("OK");
			return new ResponseEntity<ApiResponse<OrderResponseDto>>(response, HttpStatus.OK);
		}

	}

}
