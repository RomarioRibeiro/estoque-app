package com.romario.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.demo.domain.Funcionario;
import com.romario.demo.repositry.FuncionarioRepository;
import com.romario.demo.service.exeption.DatalIntegrityException;
import com.romario.demo.service.exeption.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Funcionario.class.getName() ));
	}
	
	public Funcionario inserir (Funcionario obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public Funcionario update (Funcionario obj) {
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
