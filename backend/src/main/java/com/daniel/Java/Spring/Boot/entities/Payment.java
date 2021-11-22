package com.daniel.Java.Spring.Boot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.daniel.Java.Spring.Boot.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name="tb_payment")
@Inheritance(strategy= InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")// essa anotação serve pra adicionar um campo a minha sub classe para indentificar ela
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;  // não coloquei o generated por que ele tera o mesmo id no order
	private StatePayment state;
	
	@OneToOne
	@JoinColumn(name="order_id")
	@MapsId     // essa anotação dira que o meu pedido derá o mesmo id o payment
	private Order order;
	
	public Payment() {
		
	}

	public Payment(Integer id, StatePayment state, Order orders) {
		this.id = id;
		this.state = state;
		this.order = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public StatePayment getState() {
		return state;
	}

	public void setState(StatePayment state) {
		this.state = state;
	}

	public Order getOrders() {
		return order;
	}

	public void setOrders(Order orders) {
		this.order = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
