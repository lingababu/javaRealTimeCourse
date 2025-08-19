package com.customer.serviceimpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.dto.RestPasswordDto;
import com.customer.entity.Customer;
import com.customer.mapper.CustomerMapper;
import com.customer.repo.CustomerRepo;
import com.customer.serviceinterface.CustomerService;
import com.customer.serviceinterface.EmailService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private EmailService emailService;

	@Override
	public CustomerDto login(String email, String password) {

		Customer byEmailAndPassword = customerRepo.findByEmailAndPassword(email, password);

		if (byEmailAndPassword == null) {
			return null;
		}

		CustomerDto convertToDto = CustomerMapper.convertToDto(byEmailAndPassword);

		return convertToDto;
	}

	@Override
	public boolean customerRegister(CustomerDto customerDto) {

		Customer customer = CustomerMapper.convertToEntity(customerDto);

		String pwd = generatePassword();

		customer.setPassword(pwd);

		customer.setIsPasswordUpdated("No");

		Customer savedCustomer = customerRepo.save(customer);

		if (savedCustomer.getCustomerId() != null) {

			String sub = "Your registration success for E-commerce.";

			String body = "Your temporary password: " + pwd;

			return emailService.sendEmail(customerDto.getEmail(), sub, body);

		} else {
			return false;
		}

	}

	@Override
	public boolean isEmailUnique(String email) {

		Customer customer = customerRepo.findByEmail(email);

		if (customer == null) {
			return true;
		}
		return false;
	}

	@Override
	public String generatePassword() {

		StringBuffer sb = new StringBuffer();

		Random random = new Random();

		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321";

		int length = 5;

		for (int i = 0; i < length; i++) {

			int index = random.nextInt(chars.length());

			char charAt = chars.charAt(index);

			sb.append(charAt);
		}

		return sb.toString();
	}

	@Override
	public boolean resetPassword(RestPasswordDto restPasswordDto) {

		Customer customer = customerRepo.findByEmail(restPasswordDto.getEmail());

		if (customer == null) {

			return false;
		}

		customer.setPassword(restPasswordDto.getNewPassword());

		customer.setIsPasswordUpdated("Yes");

		customerRepo.save(customer);

		return true;
	}

	@Override
	public CustomerDto getCustomer(String email) {

		Customer customer = customerRepo.findByEmail(email);
		
		CustomerDto customerDto = CustomerMapper.convertToDto(customer);

		return customerDto;
	}

}
