package com.daniel.Java.Spring.Boot.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.daniel.Java.Spring.Boot.entities.pk.ItemOrderPk;

@Entity
@Table(name="tb_item_order")
public class ItemOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemOrderPk id = new ItemOrderPk();
	private String description;
	private Integer quantity;
	private Double price;
	
	public ItemOrder() {
		
	}

	public ItemOrder(Order order, Product product, String description, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public ItemOrderPk getId() {
		return id;
	}

	public void setId(ItemOrderPk id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	

}
