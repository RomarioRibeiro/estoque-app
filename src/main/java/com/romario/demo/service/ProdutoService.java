package com.romario.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.demo.domain.Produto;
import com.romario.demo.repositry.ProdutoRepository;
import com.romario.demo.service.exeption.DatalIntegrityException;
import com.romario.demo.service.exeption.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Produto.class.getName() ));
	}
	
	public Produto inserir (Produto obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public Produto update (Produto obj) {
		find(obj.getId());
		
		return repo.save(obj);
	}
	
	public void  delete(Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		} catch (DatalIntegrityException e ) {
		throw  new DatalIntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}
	
	}

	
}
