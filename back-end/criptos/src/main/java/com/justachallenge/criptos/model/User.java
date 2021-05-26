package com.justachallenge.criptos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String login;

	private String password;

	private String email;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private WatchList watchList;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private PersonalInfo personalInfo;

	public User(String login, String password, String email, WatchList watchList, PersonalInfo personalInfo) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.watchList = watchList;
		this.personalInfo = personalInfo;

	}

	public User() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WatchList getWatchList() {
		return watchList;
	}

	public void setWatchList(WatchList watchList) {
		this.watchList = watchList;
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
