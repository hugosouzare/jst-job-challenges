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
public class WatchList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long watchListId;

	@OneToMany(mappedBy = "watchList", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<CryptoCurrency> cryptoList = new ArrayList<>();

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private User user;

	public WatchList(List<CryptoCurrency> cryptoList, User user) {
		super();
		this.cryptoList = cryptoList;
		this.user = user;
	}

	public WatchList() {

	}

	public List<CryptoCurrency> getCryptoList() {
		return cryptoList;
	}

	public void setCryptoList(List<CryptoCurrency> cryptoList) {
		this.cryptoList = cryptoList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
