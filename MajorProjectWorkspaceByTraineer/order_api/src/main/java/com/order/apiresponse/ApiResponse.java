package com.order.apiresponse;

import lombok.Data;

@Data
public class ApiResponse<T> {

	private String message;
	private String status;
	private T data;

}
