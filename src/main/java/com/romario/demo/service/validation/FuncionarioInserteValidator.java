package com.romario.demo.service.validation;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.romario.demo.domain.Funcionario;
import com.romario.demo.dto.FuncionarioNewDTO;
import com.romario.demo.repositry.FuncionarioRepository;
import com.romario.demo.resource.exeption.FieldMessage;

public class FuncionarioInserteValidator implements ConstraintValidator<FuncionarioInserte, FuncionarioNewDTO> {

	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public void initialize(FuncionarioInserte ann) {
	}
	
	@Override
	public boolean isValid(FuncionarioNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Funcionario aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já Existente"));
		}
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFildName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	
	
	}

}
