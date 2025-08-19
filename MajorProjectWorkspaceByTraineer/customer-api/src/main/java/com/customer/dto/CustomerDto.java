package com.customer.dto;

import lombok.Data;

@Data
public class CustomerDto {
	
	private Integer customerId;

	private String name;

	private String email;

	private Long phno;

	private String password;

	private String isPasswordUpdated;

}
