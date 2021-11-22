package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.entities.ItemOrder;
import com.daniel.Java.Spring.Boot.entities.Order;
import com.daniel.Java.Spring.Boot.entities.Payment;
import com.daniel.Java.Spring.Boot.enums.StatePayment;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Instant date;
	
	private Integer idPayment;
	private StatePayment state;
	
	private Integer idClient;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer type;

	private String logarant;
	private Integer number;
	private String complement;
	private String district;
	private String cep;
	
	List<ItemOrderDTO> products = new ArrayList<>();
	
	public OrderDTO(Order entity) {
		id = entity.getId();
		date = entity.getDate();
		idPayment = entity.getPayment().getId();
		state = entity.getPayment().getState();
		idClient = entity.getClient().getId();
		name = entity.getClient().getName();
		email = entity.getClient().getEmail();
		cpfOrCnpj = entity.getClient().getCpfOrCnpj();
		type = entity.getClient().getType().getCode();
		logarant = entity.getDeliveryAddress().getLogarant();
		number = entity.getDeliveryAddress().getNumber();
		complement = entity.getDeliveryAddress().getComplement();
		district = entity.getDeliveryAddress().getDistrict();
		cep = entity.getDeliveryAddress().getCep();
		
	}

	public OrderDTO(Order entity, Set<ItemOrder> products) {
	   this(entity);
	   products.forEach(x -> this.products.add(new ItemOrderDTO(x)));
	}

	public Double getTotalValue() {
		double sum = 0.0;
		for(ItemOrderDTO x: products) {
			sum += x.getSubTotal();
		}
		return sum;
	}
	
	

	public List<ItemOrderDTO> getProducts() {
		return products;
	}

	public String getLogarant() {
		return logarant;
	}

	public void setLogarant(String logarant) {
		this.logarant = logarant;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}

	public StatePayment getState() {
		return state;
	}

	public void setState(StatePayment state) {
		this.state = state;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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
