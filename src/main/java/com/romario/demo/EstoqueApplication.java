package com.romario.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import com.romario.demo.domain.Categoria;
import com.romario.demo.domain.Estoque;
import com.romario.demo.domain.Funcionario;
import com.romario.demo.domain.Item_Estoque;
import com.romario.demo.domain.Produto;
import com.romario.demo.repositry.CategoriaRepository;
import com.romario.demo.repositry.EstoqueRepository;
import com.romario.demo.repositry.FuncionarioRepository;
import com.romario.demo.repositry.Item_EstoqueRepository;
import com.romario.demo.repositry.ProdutoRepository;
@EnableAsync
@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner {


	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);

		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


	

}
