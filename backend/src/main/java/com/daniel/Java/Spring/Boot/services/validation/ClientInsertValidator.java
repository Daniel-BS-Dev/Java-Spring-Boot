package com.daniel.Java.Spring.Boot.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.daniel.Java.Spring.Boot.dto.ClientInsertDTO;
import com.daniel.Java.Spring.Boot.enums.TypeClient;
import com.daniel.Java.Spring.Boot.resources.exceptions.FieldMessage;
import com.daniel.Java.Spring.Boot.services.validation.utils.ValidationCpfOrCnpj;

public class ClientInsertValidator implements ConstraintValidator<ClientInsertValid, ClientInsertDTO> {

	
	@Override
	public void initialize(ClientInsertValid ann) {
	}

	@Override
	public boolean isValid(ClientInsertDTO dto, ConstraintValidatorContext context) {
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(dto.getType().equals(TypeClient.PESSOAFISICA.getCode()) && !ValidationCpfOrCnpj.isValidCPF(dto.getCpfOrCnpj())) {
			list.add(new FieldMessage("CpfOrCnpj" , "CPF invalido"));
		}
		
		if(dto.getType().equals(TypeClient.PESSOAJURIDICA.getCode()) && !ValidationCpfOrCnpj.isValidCNPJ(dto.getCpfOrCnpj())) {
			list.add(new FieldMessage("CpfOrCnpj" , "CNPJ invalido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getStatus())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}