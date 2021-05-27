package com.justachallenge.criptos.enums;

import java.util.Arrays;
import java.util.List;

public enum Profile {

	ADMIN(1, "ROLE_ADMIN"),
	USER(2, "ROLE_USER");
	
	private int cod;
	private String role;
	
	private Profile(int cod, String role) {
		this.cod = cod;
		this.role = role;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public static Profile toEnum(Integer cod) {
		
		
		if (cod == null) {
			return null;
		}
		
		for (Profile x : Profile.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		
		}
		
		throw new IllegalArgumentException("Invalid role");
	}
}
