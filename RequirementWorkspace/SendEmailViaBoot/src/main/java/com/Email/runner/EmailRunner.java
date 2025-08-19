package com.Email.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Email.service.EmailService;

@Component
public class EmailRunner implements ApplicationRunner {

	@Autowired
	private EmailService emailService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

//		emailService.sendEmail("Yanamalavijay2020@gmail.com", "Mail has been sent via spring boot program",
//				"Hey vijay!.. You are receving mail from lb via spring boot application.");

		emailService.sendEmail("Shaikafridi522@gmail.com", "Mail has been sent via spring boot program",
				"Hey Bikari!.. You are receving mail from lb via spring boot application.");

		System.out.println("Mail sent secessfully");

	}

}
