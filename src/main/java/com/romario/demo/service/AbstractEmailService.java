package com.romario.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import com.romario.demo.domain.Funcionario;
import com.romario.demo.repositry.FuncionarioRepository;

public abstract class AbstractEmailService implements EmailService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Value("${default.sender}")
	private String sander;
	
	public void sendOrderConfirmationEmail(Funcionario obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromFuncionario(obj);
		sendEmail(sm);
	}
   @Async
	private SimpleMailMessage prepareSimpleMailMessageFromFuncionario(Funcionario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		List<Funcionario> funs = funcionarioRepository.findAllCompras();
		for(Funcionario f:funs) {
			sm.setTo(f.getEmail());
			sm.setFrom(sander);
			sm.setSubject("Repor o Estoque!! Codigo: " + obj.getId());
			sm.setSentDate(new Date(System.currentTimeMillis()));
			sm.setText(obj.toString());
			
		}

		return sm;
	}

}
