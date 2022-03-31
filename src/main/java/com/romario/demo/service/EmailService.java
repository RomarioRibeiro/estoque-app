package com.romario.demo.service;

import org.springframework.mail.SimpleMailMessage;

import com.romario.demo.domain.Estoque;


public interface EmailService {
	
void sendOrderConfirmationEmail(Estoque obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Estoque estoque, String newPass);

}
