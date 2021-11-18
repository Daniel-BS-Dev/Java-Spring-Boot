package com.daniel.Java.Spring.Boot.enums;

public enum StatePayment {
	
	PENDING(1, "Pendente"),
	PAIDOUT(2, "Pago"),
	CANCEL(3,"Cancelado");
	
	private Integer code; 
	private String description;
	
	private StatePayment(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return description;
	}

	public void setName(String description) {
		this.description = description;
	}
	
	public static StatePayment toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(StatePayment x: StatePayment.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido"+ code);
	}
	

}
