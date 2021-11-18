package com.daniel.Java.Spring.Boot.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.daniel.Java.Spring.Boot.enums.StatePayment;

@Entity
@Table(name="tb_payment_with_card")
public class PaymentWithCard extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;
	
	public PaymentWithCard() {
		
	}

	public PaymentWithCard(Integer id, StatePayment state, Order orders, Integer numberOfInstallments) {
		super(id, state, orders);
		this.numberOfInstallments = numberOfInstallments;
	}
	
	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	
	
	

}
