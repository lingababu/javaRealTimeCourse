package com.usermanagement.serviceinterface;

public interface EmailServiceInterface {
	
	public boolean sendEmail(String to, String sub, String message);

}
