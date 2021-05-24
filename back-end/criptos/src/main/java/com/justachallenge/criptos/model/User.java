package com.justachallenge.criptos.model;

import javax.persistence.Entity;
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
	
	@OneToOne
	@JoinColumn(name = "WATCH_LIST_ID", referencedColumnName = "watchListId")
	private WatchList watchList;

	@OneToOne
	@JoinColumn(name = "PERSONAL_INFO_ID", referencedColumnName = "personalInfoId")
	private PersonalInfo personalInfo;
	
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
	
	
	
	
	
	
}
