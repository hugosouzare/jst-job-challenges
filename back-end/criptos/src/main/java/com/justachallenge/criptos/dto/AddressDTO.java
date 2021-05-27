package com.justachallenge.criptos.dto;

import javax.validation.constraints.NotBlank;

/**
* Classe DTO para cadastro de endereço
**/
public class AddressDTO {

	@NotBlank
	private String zipCode;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String number;
	
	
	private String optionalAddress;

	
	

	public AddressDTO(@NotBlank String zipCode, @NotBlank String street, @NotBlank String number,
			String optionalAddress) {
		super();
		this.zipCode = zipCode;
		this.street = street;
		this.number = number;
		this.optionalAddress = optionalAddress;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
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
	
	
}
