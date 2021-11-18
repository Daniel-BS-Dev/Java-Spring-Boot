package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.time.Instant;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.entities.Order;
import com.daniel.Java.Spring.Boot.entities.Payment;
import com.daniel.Java.Spring.Boot.enums.StatePayment;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Instant date;
	private String client;
	private StatePayment payment;
	private Integer deliveryAddress;
	
	
	public OrderDTO(Instant date, Client client, Payment payment, Address deliveryAddress) {
		this.date = date;
		this.client = client.getName();
		this.payment = payment.getState();
		this.deliveryAddress = deliveryAddress.getNumber();
	}
	
	public OrderDTO(Order entity) {
		date = entity.getDate();
		client = entity.getClient().getName();
		payment = entity.getPayment().getState();
		deliveryAddress = entity.getDeliveryAddress().getNumber();
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public StatePayment getPayment() {
		return payment;
	}

	public void setPayment(StatePayment payment) {
		this.payment = payment;
	}

	public Integer getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Integer deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
	

	
	
	
	
	
	
	
}
