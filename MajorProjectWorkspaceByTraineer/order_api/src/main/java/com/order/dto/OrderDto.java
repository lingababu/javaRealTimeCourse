package com.order.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDto {

	private Integer orderId;

	private String orderTrackingNumber;

	private String razorPayOrderId;

	private String email;

	private String orderStatus;

	private BigDecimal totalPrice;

	private Integer totalQuantity;

	private String razorPayPaymentId;

	private LocalDateTime dateCreated;

	private LocalDateTime lastUpdated;

	private LocalDate deliveryDate;

}
