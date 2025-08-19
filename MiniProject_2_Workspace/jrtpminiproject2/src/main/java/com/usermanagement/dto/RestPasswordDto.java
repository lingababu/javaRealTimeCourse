package com.usermanagement.dto;

import lombok.Data;

@Data
public class RestPasswordDto {

	private String email;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

}
