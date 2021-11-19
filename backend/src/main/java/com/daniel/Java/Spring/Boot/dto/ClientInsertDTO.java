package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.Client;

public class ClientInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "Preenchimento obrigatoro")
	@Length(min=2, max=50, message="Tamanho deve ser enter 2 e 50 caracteres")
	private String name;
	
	@NotBlank(message = "Preenchimento obrigatoro")
	@Email(message = "Email invalido")
	private String email;
	
	@NotBlank(message = "Preenchimento obrigatoro")
	private String cpfOrCnpj;
	private Integer type; 

	public ClientInsertDTO(Integer id, String name, String email, String cpfOrCnpj, Integer type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = type;
	}
	
	public ClientInsertDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpfOrCnpj = entity.getCpfOrCnpj();
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

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


}
