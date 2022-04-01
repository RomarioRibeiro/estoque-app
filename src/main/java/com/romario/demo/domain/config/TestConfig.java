package com.romario.demo.domain.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.romario.demo.service.DBService;
//<<<<<<< HEAD
import com.romario.demo.service.EmailService;
import com.romario.demo.service.MockEmailService;
//=======
//>>>>>>> cd2ae11c67432de8942283517a93099c7e09dd7b


@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instatiateDatabase( ) throws ParseException {
	dbService.instantiateTestDatabase();
	return true;	
	}
	
//<<<<<<< HEAD
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
//=======
//>>>>>>> cd2ae11c67432de8942283517a93099c7e09dd7b
	
}
