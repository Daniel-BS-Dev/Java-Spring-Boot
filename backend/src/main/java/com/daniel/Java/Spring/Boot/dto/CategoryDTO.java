package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.entities.Product;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	List<ProductDTO> product = new ArrayList<>();
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Long id, String name) {
		this.name=name;
		this.id = id;
	}
	
	public CategoryDTO(Category entity) {
		name = entity.getName();
		id = entity.getId();
	}
	
	public CategoryDTO(Category entity, List<Product> product) {
	    this(entity);
	    product.forEach(x -> this.product.add(new ProductDTO(x)));	
		
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

	public List<ProductDTO> getProduct() {
		return product;
	}



}
