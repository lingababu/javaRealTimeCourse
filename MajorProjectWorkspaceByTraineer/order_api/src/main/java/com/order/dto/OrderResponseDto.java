package com.order.dto;

import lombok.Data;

@Data
public class OrderResponseDto {
	
	private String razorPayOrderId;
	
	private String orderStatus;
	
	private String orderTrackingNumber;

}
