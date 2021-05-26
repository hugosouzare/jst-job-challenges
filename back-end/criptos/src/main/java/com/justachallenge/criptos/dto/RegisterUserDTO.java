package com.justachallenge.criptos.dto;

import javax.validation.constraints.NotBlank;

public class RegisterUserDTO {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String email;

	@NotBlank
	private String name;

	@NotBlank
	private String lastName;

	@NotBlank
	private String phone;

	public RegisterUserDTO(@NotBlank String username, @NotBlank String password, @NotBlank String email,
			@NotBlank String name, @NotBlank String lastName, @NotBlank String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
