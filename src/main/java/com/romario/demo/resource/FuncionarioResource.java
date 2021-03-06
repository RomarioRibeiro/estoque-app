package com.romario.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.demo.domain.Funcionario;
import com.romario.demo.dto.FuncionarioDTO;
import com.romario.demo.dto.FuncionarioNewDTO;
import com.romario.demo.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Funcionario> find(@PathVariable Integer id) {
		Funcionario obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert  (@Valid @RequestBody FuncionarioNewDTO objDto) {
		Funcionario obj = service.fromDTO(objDto);
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FuncionarioDTO objDto, @PathVariable Integer id) {
		System.out.println(objDto.getEmail());
		Funcionario obj = service.fromDTO(objDto);
		
		obj.setId(id);
	 obj = service.update(obj);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findPage() {
				List<Funcionario> list = service.findAll();
				List<FuncionarioDTO> listDto = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value= "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<FuncionarioDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0" ) Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24" ) Integer linesPerPage, 
			@RequestParam(value ="ordeBy", defaultValue = "nome" ) String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC" ) String direction) {
				Page<Funcionario> list = service.findPage(page,linesPerPage,orderBy,direction);
				Page<FuncionarioDTO> listDto = list.map(obj -> new FuncionarioDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
	}
}
