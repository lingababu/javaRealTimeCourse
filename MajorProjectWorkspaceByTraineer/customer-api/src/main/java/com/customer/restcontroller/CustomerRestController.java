package com.customer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.apiresponse.ApiResponse;
import com.customer.dto.CustomerDto;
import com.customer.dto.RestPasswordDto;
import com.customer.serviceinterface.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/login")
	public ResponseEntity<ApiResponse<CustomerDto>> login(@RequestBody CustomerDto customerDto) {

		ApiResponse<CustomerDto> response = new ApiResponse<>();

		CustomerDto login = customerService.login(customerDto.getEmail(), customerDto.getPassword());

		if (login == null) {

			response.setStatus(400);
			response.setMessage("Invalid credentails");
			response.setData(null);
			return new ResponseEntity<ApiResponse<CustomerDto>>(HttpStatus.BAD_REQUEST);
		} else {

			response.setData(login);
			response.setMessage("Login Successfull.");
			response.setStatus(200);
			return new ResponseEntity<ApiResponse<CustomerDto>>(response, HttpStatus.OK);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<String>> customerRegister(@RequestBody CustomerDto customerDto) {

		ApiResponse<String> response = new ApiResponse<>();

		boolean emailUnique = customerService.isEmailUnique(customerDto.getEmail());

		if (!emailUnique) {

			response.setData("Email already used.");
			response.setMessage("Duplicate email not allowed.");
			response.setStatus(400);

			return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.BAD_REQUEST);
		}

		boolean customerRegister = customerService.customerRegister(customerDto);

		if (customerRegister) {
			response.setStatus(201);
			response.setMessage("CREATED");
			response.setData("Registration successfull.");

			return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.CREATED);
		} else {
			response.setData("Registration failed.");
			response.setMessage("BAD REQUEST");
			response.setStatus(400);
			return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/resetPassword")
	public ResponseEntity<ApiResponse<String>> resetPassword(RestPasswordDto restPasswordDto) {

		ApiResponse<String> response = new ApiResponse<>();

		boolean resetPassword = customerService.resetPassword(restPasswordDto);

		if (resetPassword) {

			response.setData("Password changed successfully.");
			response.setMessage("OK");
			response.setStatus(200);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setData("Reset password failed");
			response.setMessage("BAD REQUEST");
			response.setStatus(400);

			return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getCustomer/{email}")
	public ResponseEntity<ApiResponse<CustomerDto>> getCustomer(@PathVariable String email) {

		ApiResponse<CustomerDto> response = new ApiResponse<CustomerDto>();

		CustomerDto customer = customerService.getCustomer(email);

		if (customer == null) {

			response.setMessage("Fetching customer failed.");
			response.setData(null);
			response.setStatus(400);
			return new ResponseEntity<ApiResponse<CustomerDto>>(response, HttpStatus.BAD_REQUEST);

		} else {
			response.setData(customer);
			response.setMessage("Fetched customer.");
			response.setStatus(200);
			return new ResponseEntity<ApiResponse<CustomerDto>>(response, HttpStatus.OK);
		}

	}

}
