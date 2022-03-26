package com.romario.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class DBService {

	
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
	
	
	public void  instantiateTestDatabase() throws ParseException {
		

		Categoria cat = new Categoria(null, "Limpeza");
		Produto prod = new Produto(null, "Omo");		
		
		categoriaRepository.saveAll(Arrays.asList(cat));
		prod.setCategoria(cat);
		produtoRepository.saveAll(Arrays.asList(prod));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Funcionario fun = new Funcionario(null, "Romario", "43003416804", "romaryjane@hotmail.com", sdf.parse("01/05/1997 22:03"));
		funcionarioRepository.saveAll(Arrays.asList(fun));
		
		
		Estoque est = new Estoque(null, "Insumos");
		Estoque est2 = new Estoque(null, "Limpeza");

		
		estoqueRepository.saveAll(Arrays.asList(est,est2));
		
		Item_Estoque it1 = new Item_Estoque(est, prod, 12);
		Item_Estoque it2 = new Item_Estoque(est2, prod, 12);
		
		
		est.getItens().addAll(Arrays.asList(it1));
		est2.getItens().addAll(Arrays.asList(it2));
		
		itemestoquerepository.saveAll(Arrays.asList(it1,it2));
		
		
	}
}
