package com.romario.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.romario.demo.domain.Funcionario;
import com.romario.demo.dto.FuncionarioDTO;
import com.romario.demo.dto.FuncionarioNewDTO;
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
		obj.setDataDeNasc(new Date(System.currentTimeMillis()));
		
		return repo.save(obj);
	}
	
	public List<Funcionario> findAll(){
		
		return repo.findAll();
	}
	
	public Funcionario update (Funcionario obj) {
	Funcionario newobj = find(obj.getId());
		updateData(newobj, obj);
		
		return repo.save(newobj);
	}
	
	public void  delete(Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		} catch (DatalIntegrityException e ) {
		throw  new DatalIntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}
	
	}
	
	
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Funcionario fromDTO(FuncionarioDTO objDto) {
		return new Funcionario(objDto.getId(), objDto.getNome(), objDto.getEmail(),null , null,objDto.getPerfil());
	}
	
	private void updateData(Funcionario newobj ,Funcionario obj) {
		newobj.setNome(obj.getNome());
		newobj.setEmail(obj.getEmail());
		newobj.setPerfil(obj.getPerfil());
	}
	
	
	public Funcionario fromDTO(FuncionarioNewDTO objDto) {
		Funcionario cli = new Funcionario(null, objDto.getNome(), objDto.getEmail(), objDto.getCpf(),null,objDto.getPerfil() );
	
	return cli;
	}
	
}
