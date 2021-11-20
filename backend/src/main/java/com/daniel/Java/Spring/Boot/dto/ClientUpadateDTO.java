package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.services.validation.ClientUpadateValid;

@ClientUpadateValid
public class ClientUpadateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "Preenchimento obrigatoro")
	@Length(min=2, max=50, message="Tamanho deve ser enter 2 e 50 caracteres")
	private String name;
	
	@NotBlank(message = "Preenchimento obrigatoro")
	@Email(message = "Email invalido")
	private String email;
	
	private Integer type; 

	public ClientUpadateDTO(Integer id, String name, String email, Integer type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
	}
	
	public ClientUpadateDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		type = entity.getType().getCode();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


}
