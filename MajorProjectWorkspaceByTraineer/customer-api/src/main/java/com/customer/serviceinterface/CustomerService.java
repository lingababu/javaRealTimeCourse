package com.customer.serviceinterface;

import com.customer.dto.CustomerDto;
import com.customer.dto.RestPasswordDto;

public interface CustomerService {
	
	public CustomerDto login(String email, String password);
	
	public boolean customerRegister(CustomerDto customerDto);
	
	public boolean isEmailUnique(String email);
	
	public boolean resetPassword(RestPasswordDto restPasswordDto);
	
	public CustomerDto getCustomer(String email);
	
	public String generatePassword();

}
