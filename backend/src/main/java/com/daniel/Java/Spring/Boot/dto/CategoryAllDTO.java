package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.daniel.Java.Spring.Boot.entities.Category;


public class CategoryAllDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Preenchimento obrigatoro")
	@Length(min=5, max=80, message="Tamanho deve ser enter 5 e 80 caracteres")
	private String name;
	
	public CategoryAllDTO() {
		
	}
	
	public CategoryAllDTO(Long id, String name) {
		this.name=name;
		this.id = id;
	}
	
	public CategoryAllDTO(Category entity) {
		name = entity.getName();
		id = entity.getId();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
