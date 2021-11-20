package com.daniel.Java.Spring.Boot.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.daniel.Java.Spring.Boot.dto.ClientUpadateDTO;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.repositories.ClientRepository;
import com.daniel.Java.Spring.Boot.resources.exceptions.FieldMessage;

public class ClientUpadateValidator implements ConstraintValidator<ClientUpadateValid, ClientUpadateDTO> {
	
	@Autowired
	private ClientRepository rep;
	
	@Autowired
	private HttpServletRequest request; // me permite pegar o parametro do meu http

	@Override
	public void initialize(ClientUpadateValid ann) {
	}

	@Override
	public boolean isValid(ClientUpadateDTO dto, ConstraintValidatorContext context) {
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		
		
		//com esse codigo a minha plaforma me permite pegar o numero que eu passei na uri
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		
		List<FieldMessage> list = new ArrayList<>();
		
		
		Client client = rep.findByEmail(dto.getEmail());
		
		
		if(client != null && !client.getId().equals(uriId)) {
			list.add(new FieldMessage("Email:", "Email ja existe"));
			
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getStatus())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}