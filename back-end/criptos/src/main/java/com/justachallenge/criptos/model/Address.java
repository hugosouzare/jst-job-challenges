package com.justachallenge.criptos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	
	private String city;
	
	private String zipCode;
	
	private String state;
	
	private String number;
	
	private String optionalAddress;
	
	@ManyToOne
	@JoinColumn(name="PERSONAL_INFO_ID", referencedColumnName = "personalInfoId")
	private PersonalInfo personalInfo;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOptionalAddress() {
		return optionalAddress;
	}

	public void setOptionalAddress(String optionalAddress) {
		this.optionalAddress = optionalAddress;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	
	
	
}
