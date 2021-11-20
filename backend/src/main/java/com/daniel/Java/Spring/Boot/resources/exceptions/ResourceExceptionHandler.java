package com.daniel.Java.Spring.Boot.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.Java.Spring.Boot.services.exceptions.DatabaseException;
import com.daniel.Java.Spring.Boot.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StantardError> categoryNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
	   StantardError err = new 	StantardError();
	   err.setTimestamp(Instant.now());
	   err.setStatus(status.value());
	   err.setError("resource not found");
	   err.setMessage(e.getMessage());
	   err.setPath(request.getRequestURI());
	   return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StantardError> dataIntegrityVaiolation(DatabaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
	   StantardError err = new 	StantardError();
	   err.setTimestamp(Instant.now());
	   err.setStatus(status.value());
	   err.setError("Integrity Violation");
	   err.setMessage(e.getMessage());
	   err.setPath(request.getRequestURI());
	   return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validationerror(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
	   ValidationError err = new ValidationError();
	   err.setTimestamp(Instant.now());
	   err.setStatus(status.value());
	   err.setError("Error");
	   err.setMessage(e.getMessage());
	   err.setPath(request.getRequestURI());
	   
	   for(FieldError x: e.getBindingResult().getFieldErrors()) {
		   err.addError(x.getField(), x.getDefaultMessage());
	   }
	   return ResponseEntity.status(status).body(err);
	}
	

}
