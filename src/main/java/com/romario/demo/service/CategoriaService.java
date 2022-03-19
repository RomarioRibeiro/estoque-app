package com.romario.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.demo.domain.Categoria;
import com.romario.demo.repositry.CategoriaRepository;
import com.romario.demo.service.exeption.DatalIntegrityException;
import com.romario.demo.service.exeption.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Categoria.class.getName() ));
	}
	
	public Categoria inserir (Categoria obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public Categoria update (Categoria obj) {
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
