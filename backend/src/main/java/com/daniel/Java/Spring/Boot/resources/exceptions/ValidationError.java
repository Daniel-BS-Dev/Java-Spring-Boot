package com.daniel.Java.Spring.Boot.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class ValidationError extends StantardError{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erro = new ArrayList<>();

	public ValidationError() {

	}

	public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErro() {
		return erro;
	}

	public void addError(String message, String status) {
		erro.add(new FieldMessage(status, message));
	}
	
	
	

}
