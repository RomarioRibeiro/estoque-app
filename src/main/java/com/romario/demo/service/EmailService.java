package com.romario.demo.service;

import org.springframework.mail.SimpleMailMessage;

import com.romario.demo.domain.Funcionario;


public interface EmailService {
	
void sendOrderConfirmationEmail(Funcionario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
<<<<<<< HEAD
	//void sendNewPasswordEmail(Estoque estoque, String newPass);
=======
	void sendNewPasswordEmail(Funcionario estoque, String newPass);

	
>>>>>>> 08f1a1ab1c1ee5f8e4739949ec1d17d3737b84b9

}
