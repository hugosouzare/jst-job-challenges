package com.justachallenge.criptos.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justachallenge.criptos.enums.Profile;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String login;

	@JsonIgnore
	private String password;

	private String email;

	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private WatchList watchList;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private PersonalInfo personalInfo;
	
	@JsonIgnore
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILES")
    private Set<Integer> profiles = new HashSet<>();
	
	public User(String login, String password, String email, WatchList watchList, PersonalInfo personalInfo) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.watchList = watchList;
		this.personalInfo = personalInfo;
		addProfile(Profile.USER);

	}

	public User() {
		super();
		addProfile(Profile.USER);
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

	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addProfile (Profile profile) {
		profiles.add(profile.getCod());
	}
	

	public Long getUserId() {
		return userId;
	}
}
