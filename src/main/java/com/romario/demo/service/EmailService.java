package com.romario.demo.service;

import org.springframework.mail.SimpleMailMessage;

import com.romario.demo.domain.Funcionario;

public interface EmailService {
	
void sendOrderConfirmationEmail(Funcionario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Funcionario funcionario, String newPass);

}
