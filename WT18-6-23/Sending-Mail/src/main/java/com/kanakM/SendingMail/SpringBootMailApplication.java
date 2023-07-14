package com.kanakM.SendingMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootMailApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/mail")
	public void sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("malviyakanak4@gmail.com");
		message.setTo("malviyakanak4@gmail.com");
		message.setSubject("Test Mail");
		message.setText("This is a test mail.");

		Object object = new Object();
		String objectAsString = object.toString();

		message.setText(objectAsString);

		javaMailSender.send(message);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMailApplication.class, args);
	}
}