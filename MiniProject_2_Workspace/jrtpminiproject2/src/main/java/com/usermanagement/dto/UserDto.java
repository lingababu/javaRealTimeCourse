package com.usermanagement.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer userId;
	private String name;
	private String email;
	private Long phoneNumber;
	private String password;
	private String passwordUpdated;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;

}
