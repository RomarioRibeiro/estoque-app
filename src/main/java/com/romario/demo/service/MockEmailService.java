package com.romario.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

<<<<<<< HEAD
=======
import com.romario.demo.domain.Funcionario;

>>>>>>> 08f1a1ab1c1ee5f8e4739949ec1d17d3737b84b9
public class MockEmailService extends  AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando Enviando email...");
		LOG.info(msg.toString());
		LOG.info("Email Enviado!");
		
	}

<<<<<<< HEAD
	
=======
	@Override
	public void sendOrderConfirmationEmail(Funcionario obj) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> 08f1a1ab1c1ee5f8e4739949ec1d17d3737b84b9

	@Override
	public void sendNewPasswordEmail(Funcionario estoque, String newPass) {
		// TODO Auto-generated method stub
		
	}



}
