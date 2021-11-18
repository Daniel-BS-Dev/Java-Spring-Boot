package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.City;
import com.daniel.Java.Spring.Boot.entities.Client;

public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String logarant;
	private Integer number;
	private String complement;
	private String district;
	private String cep;

	private String city;

	public AddressDTO(String logarant, Integer number, String complement, String district, String cep, City city) {
		this.logarant = logarant;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.cep = cep;
		this.city = city.getName();
	}
	public AddressDTO(Address entity) {
		logarant = entity.getLogarant();
		number = entity.getNumber();
		complement = entity.getComplement();
		district = entity.getDistrict();
		cep = entity.getCep();
		city = entity.getCity().getName();
	
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

	public String getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city.getName();
	}
	
	
	
	

}
