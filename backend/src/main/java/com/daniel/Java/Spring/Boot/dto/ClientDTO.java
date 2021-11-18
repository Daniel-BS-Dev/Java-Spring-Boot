package com.daniel.Java.Spring.Boot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.daniel.Java.Spring.Boot.entities.Address;
import com.daniel.Java.Spring.Boot.entities.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer type; 

	private List<AddressDTO> address = new ArrayList<>();
	
	private List<String> phones = new ArrayList<>();

	public ClientDTO(String name, String email, String cpfOrCnpj, Integer type) {
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = type;
	}
	
	public ClientDTO(Client entity) {
		name = entity.getName();
		email = entity.getEmail();
		cpfOrCnpj = entity.getCpfOrCnpj();
		type = entity.getType().getCode();
	}
	
	public ClientDTO(Client entity, List<Address> list, Set<String> set) {
		this(entity);
		list.forEach(x -> this.address.add(new AddressDTO(x)));
		set.forEach(x -> this.phones.add(x));
		
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

	public List<AddressDTO> getAddress() {
		return address;
	}

	public List<String> getPhones() {
		return phones;
	}
	
	
	

}
