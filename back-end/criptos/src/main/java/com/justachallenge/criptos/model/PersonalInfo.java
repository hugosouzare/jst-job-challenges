package com.justachallenge.criptos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personalInfoId;

	private String name;

	private String lastName;

	private String phone;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private User user;

	@OneToMany(mappedBy = "personalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> address = new ArrayList<>();

	public PersonalInfo(String name, String lastName, String phone) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PersonalInfo() {
		super();
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

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
