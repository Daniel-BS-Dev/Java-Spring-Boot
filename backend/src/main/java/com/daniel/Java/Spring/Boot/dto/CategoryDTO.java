package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;

import com.daniel.Java.Spring.Boot.entities.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(String name) {
		this.name=name;
	}
	
	public CategoryDTO(Category entity) {
		name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
