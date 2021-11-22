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
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public ItemOrder() {
		
	}

	public ItemOrder(Order order, Product product, Double discount, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public void setId(Product product) {
		id.setProduct(product);
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double description) {
		this.discount = description;
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
