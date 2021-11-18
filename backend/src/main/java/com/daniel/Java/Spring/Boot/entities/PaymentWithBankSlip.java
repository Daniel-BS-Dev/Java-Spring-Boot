package com.daniel.Java.Spring.Boot.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.daniel.Java.Spring.Boot.enums.StatePayment;

@Entity
@Table(name="tb_payment_with_bank_slip")
public class PaymentWithBankSlip extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
     private Instant dueDate;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
     private Instant payDate;
	
	public PaymentWithBankSlip() {
		
	}

	public PaymentWithBankSlip(Integer id, StatePayment state, Order orders,Instant dueDate, Instant payDate) {
		super(id, state, orders);
		this.dueDate = dueDate;
		this.payDate = payDate;
		
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}

	public Instant getPayDate() {
		return payDate;
	}

	public void setPayDate(Instant payDate) {
		this.payDate = payDate;
	}

	

	
	

}
