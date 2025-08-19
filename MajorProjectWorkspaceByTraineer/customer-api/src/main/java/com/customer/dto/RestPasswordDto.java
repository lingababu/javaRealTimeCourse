package com.customer.dto;

import lombok.Data;

@Data
public class RestPasswordDto {
	
	private String email;

	private String oldpassword;

	private String newPassword;
	
	private String confirmPassword;

}
