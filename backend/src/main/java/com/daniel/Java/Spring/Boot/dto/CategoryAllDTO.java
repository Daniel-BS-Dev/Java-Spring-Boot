package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.entities.Product;

public class CategoryAllDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
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
