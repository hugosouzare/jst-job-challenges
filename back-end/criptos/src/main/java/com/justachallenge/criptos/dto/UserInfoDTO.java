package com.justachallenge.criptos.dto;

import com.justachallenge.criptos.model.PersonalInfo;

public class UserInfoDTO {

	
	private String username;
	
	private String email;
	
	private PersonalInfo personalInfo;
	
	

	public UserInfoDTO(String username, String email, PersonalInfo personalInfo) {
		super();
		this.username = username;
		this.email = email;
		this.personalInfo = personalInfo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	
}
