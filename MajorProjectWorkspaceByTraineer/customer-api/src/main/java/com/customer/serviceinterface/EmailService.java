package com.customer.serviceinterface;

public interface EmailService {
	
	public boolean sendEmail(String to, String sub, String body);

}
