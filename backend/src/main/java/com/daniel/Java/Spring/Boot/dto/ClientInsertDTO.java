package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.Client;
import com.daniel.Java.Spring.Boot.services.validation.ClientInsertValid;

@ClientInsertValid
public class ClientInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id;
    
    @NotBlank(message="Esse campo é obrigatorio")
	private String name;
    
    @NotBlank(message="Esse campo é obrigatorio")
    @Email(message= "Email invalido")
	private String email;
    
    @NotBlank(message="Esse campo é obrigatorio")
    @PositiveOrZero(message = "So aceita numeros positivo ou 0")
	private String cpfOrCnpj;
	private Integer type;
	private String logarant;
	
	@NotNull(message="Esse campo é obrigatorio")
	@PositiveOrZero(message = "So aceita numeros positivo ou 0")
	private Integer number;
	
	@NotBlank(message="Esse campo é obrigatorio")
	private String complement;
	
	@NotBlank(message="Esse campo é obrigatorio")
	private String district;
	
	@NotBlank(message="Esse campo é obrigatorio")
	@PositiveOrZero(message = "So aceita numeros positivo ou 0")
	private String phone;
	
	private Integer city;
	
	@PositiveOrZero(message = "So aceita numeros positivo ou 0")
	private String cep;
	
	
	public ClientInsertDTO(Integer id, String name, String email, String cpfOrCnpj, Integer type, String logarant,
			Integer number, String complement, String district, String phone, Integer city, String cep) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = type;
		this.logarant = logarant;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.phone = phone;
		this.city = city;
		this.cep = cep;
	}
	
	public ClientInsertDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpfOrCnpj = entity.getCpfOrCnpj();
		type = entity.getType().getCode();
		entity.getPhones().add(phone);
		
		for(Address x: entity.getAddress()) {

			logarant = x.getLogarant();
			number = x.getNumber();
			complement = x.getComplement();
		    district = x.getDistrict();
			cep = x.getCep();
			city = x.getCity().getId();
			
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
}