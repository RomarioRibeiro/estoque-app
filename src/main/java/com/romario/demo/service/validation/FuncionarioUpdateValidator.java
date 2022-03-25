package com.romario.demo.service.validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.romario.demo.domain.Funcionario;
import com.romario.demo.dto.FuncionarioDTO;
import com.romario.demo.repositry.FuncionarioRepository;
import com.romario.demo.resource.exeption.FieldMessage;

public class FuncionarioUpdateValidator implements ConstraintValidator<FuncionarioInserte, FuncionarioDTO> {
	
	@Autowired
	private HttpServletRequest request; 
	

	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public void initialize(FuncionarioInserte ann) {
	}
	
	@Override
	public boolean isValid(FuncionarioDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String , String> map = (Map<String , String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriID = Integer.parseInt(map.get("id"));
		
		
		List<FieldMessage> list = new ArrayList<>();
		
		Funcionario aux = repo.findByEmail(objDto.getEmail());
		if(aux != null  && !aux.getId().equals(uriID)) {
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
