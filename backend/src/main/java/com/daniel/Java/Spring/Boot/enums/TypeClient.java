package com.daniel.Java.Spring.Boot.enums;

public enum TypeClient {
	
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private Integer code; 
	private String name;
	
	private TypeClient(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static TypeClient toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(TypeClient x: TypeClient.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido"+ code);
	}
	

}
