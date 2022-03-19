package com.romario.demo.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.demo.domain.Estoque;
import com.romario.demo.service.EstoqueService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {

	@Autowired
	private EstoqueService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estoque> find(@PathVariable Integer id) {
		Estoque obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert  ( @RequestBody Estoque obj) {
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody Estoque obj, @PathVariable Integer id) {
		obj.setId(id);
	obj = service.update(obj);
	return ResponseEntity.noContent().build();
	}
}