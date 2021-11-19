package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.daniel.Java.Spring.Boot.entities.Client;

public class ClientAllDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;

	public ClientAllDTO(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	
	}
	
	public ClientAllDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	
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
	

}
