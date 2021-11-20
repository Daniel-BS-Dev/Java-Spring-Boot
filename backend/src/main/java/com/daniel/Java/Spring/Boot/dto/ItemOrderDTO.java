package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.entities.ItemOrder;
import com.daniel.Java.Spring.Boot.entities.Order;
import com.daniel.Java.Spring.Boot.entities.Payment;
import com.daniel.Java.Spring.Boot.enums.StatePayment;

public class ItemOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double discount;
	private Integer quantity;
	private Double price;
	
	private ProductDTO product;

	public ItemOrderDTO(Double discount, Integer quantity, Double price, ProductDTO product) {
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public ItemOrderDTO(ItemOrder entity) {
		discount = entity.getDiscount();
		quantity = entity.getQuantity();
		price = entity.getPrice();
		product.setId(entity.getProduct().getId());
		product.setName(entity.getProduct().getName());
		product.setPrice(entity.getProduct().getPrice());
	
	}
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	
	
	
	
	
}
