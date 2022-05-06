package com.romario.demo.service;

import org.springframework.mail.SimpleMailMessage;

import com.romario.demo.domain.Funcionario;


public interface EmailService {
	
void sendOrderConfirmationEmail(Funcionario obj);
	
	void sendEmail(SimpleMailMessage sm);
	
	void sendNewPasswordEmail(Funcionario estoque, String newPass);

	

}
