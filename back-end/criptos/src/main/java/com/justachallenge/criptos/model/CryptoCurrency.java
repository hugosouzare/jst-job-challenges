package com.justachallenge.criptos.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CryptoCurrency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cryptoInfoId;

	private String name;

	private String symbol;

	private String startWatchPrice;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "watchListId", referencedColumnName = "watchListId")
	private WatchList watchList;

	public CryptoCurrency(String name, String symbol, String startWatchPrice, WatchList watchList) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.startWatchPrice = startWatchPrice;
		this.watchList = watchList;
	}

	public CryptoCurrency() {
		super();
	}
	
	public Long getId() {
		return cryptoInfoId;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStartWatchPrice() {
		return startWatchPrice;
	}

	public void setStartWatchPriceUsd(String startWatchPrice) {
		this.startWatchPrice = startWatchPrice;
	}


}
