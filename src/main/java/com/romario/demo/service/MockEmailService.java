package com.romario.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.romario.demo.domain.Estoque;

public class MockEmailService extends  AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando Enviando email...");
		LOG.info(msg.toString());
		LOG.info("Email Enviado!");
		
	}

	@Override
	public void sendNewPasswordEmail(Estoque estoque, String newPass) {
		// TODO Auto-generated method stub
		
	}

}
