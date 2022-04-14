package com.romario.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.romario.demo.domain.Categoria;
import com.romario.demo.dto.CategoriaDTO;
import com.romario.demo.repositry.CategoriaRepository;
import com.romario.demo.service.exeption.DatalIntegrityException;
import com.romario.demo.service.exeption.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + Categoria.class.getName()));
	}

	public Categoria inserir(Categoria obj) {
		obj.setId(null);

		return repo.save(obj);
	}

	public List<Categoria> findAll() {

		return repo.findAll();
	}

	public Categoria update(Categoria obj) {
		Categoria newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}

	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DatalIntegrityException e) {
			throw new DatalIntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}

	}



	

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}

	private void updateData(Categoria newobj, Categoria obj) {
		newobj.setNome(obj.getNome());
		;
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
