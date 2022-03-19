package com.romario.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private Item_EstoqueRepository itemestoquerepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Categoria cat = new Categoria(null, "Limpeza");
		Produto prod = new Produto(null, "Omo");		
		
		categoriaRepository.saveAll(Arrays.asList(cat));
		prod.setCategoria(cat);
		produtoRepository.saveAll(Arrays.asList(prod));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Funcionario fun = new Funcionario(null, "Romario", "43003416804", "romaryjane@hotmail.com", sdf.parse("01/05/1997 22:03"));
		funcionarioRepository.saveAll(Arrays.asList(fun));
		
		
		Estoque est = new Estoque(null, "Insumos");

		
		estoqueRepository.saveAll(Arrays.asList(est));
		
		Item_Estoque it1 = new Item_Estoque(est, prod, 12);
		
		
		est.getItens().addAll(Arrays.asList(it1));
		
		itemestoquerepository.saveAll(Arrays.asList(it1));
		
	}
	

}
