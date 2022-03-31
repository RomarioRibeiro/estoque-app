package com.romario.demo.service;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;

import com.romario.demo.domain.Estoque;

public abstract class AbstractEmailService implements EmailService {

	@value("${default.sender}")
	private String sander;
	
	public void sendOrderConfirmationEmail(Estoque obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromEstoque(obj);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromEstoque(Estoque obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.get);
		sm.setFrom(sander);
		sm.setSubject("Repor o Estoque!! Codigo: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

}
