package com.Email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	public void sendEmail(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(fromEmail);

		message.setTo(to);

		message.setSubject(subject);

		message.setText(text);

		javaMailSender.send(message);
	}

}
