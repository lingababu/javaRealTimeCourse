package com.usermanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.usermanagement.serviceinterface.EmailServiceInterface;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailServiceInterface {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean sendEmail(String to, String sub, String message) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		try {
			mimeMessageHelper.setTo(to);

			mimeMessageHelper.setSubject(sub);

			mimeMessageHelper.setText(message, true);

			javaMailSender.send(mimeMessage);

			return true;

		} catch (MessagingException e) {

			e.printStackTrace();
		}

		return false;
	}
}
