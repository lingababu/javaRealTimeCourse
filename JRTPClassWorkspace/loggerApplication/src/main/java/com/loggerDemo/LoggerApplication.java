package com.loggerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.loggerDemo.service.UserService;

@SpringBootApplication
public class LoggerApplication {

	public static void main(String[] args) {
		ApplicationContext cnst = SpringApplication.run(LoggerApplication.class, args);
		
		UserService us =cnst.getBean(UserService.class);
		
		us.checkLoggersLevel();
	}

}
