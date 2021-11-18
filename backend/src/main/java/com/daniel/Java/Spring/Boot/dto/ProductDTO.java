package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daniel.Java.Spring.Boot.entities.Category;
import com.daniel.Java.Spring.Boot.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double price;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(String name, Double price) {
		this.name=name;
		this.price=price;
	}
	
	public ProductDTO(Product entity) {
		name = entity.getName();
		price = entity.getPrice();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	


}
