package com.justachallenge.criptos.model;

import java.math.BigDecimal;

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
    
	private BigDecimal startWatchPrice = new BigDecimal(0);

	private BigDecimal currentPrice = new BigDecimal(0);
    
	
	private BigDecimal changePercentSinceStart = new BigDecimal(0);

	private BigDecimal changePercent24Hr = new BigDecimal(0);

	@ManyToOne
	@JoinColumn(name = "watchListId", referencedColumnName = "watchListId")
	private WatchList watchList;

	
	
	public CryptoCurrency(String name, String symbol, BigDecimal startWatchPrice, BigDecimal currentPrice,
			BigDecimal changePercentSinceStart, BigDecimal changePercent24Hr, WatchList watchList) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.startWatchPrice = startWatchPrice;
		this.currentPrice = currentPrice;
		this.changePercentSinceStart = changePercentSinceStart;
		this.changePercent24Hr = changePercent24Hr;
		this.watchList = watchList;
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

	public BigDecimal getStartWatchPrice() {
		return startWatchPrice;
	}

	public void setStartWatchPriceUsd(BigDecimal startWatchPrice) {
		this.startWatchPrice = startWatchPrice;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPriceUsd(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public BigDecimal getChangePercentSinceStart() {
		return changePercentSinceStart;
	}

	public void setChangePercentSinceStart(BigDecimal changePercentSinceStart) {
		this.changePercentSinceStart = changePercentSinceStart;
	}

	public BigDecimal getChangePercent24Hr() {
		return changePercent24Hr;
	}

	public void setChangePercent24Hr(BigDecimal changePercent24Hr) {
		this.changePercent24Hr = changePercent24Hr;
	}

	public WatchList getWatchList() {
		return watchList;
	}

	public void setWatchList(WatchList watchList) {
		this.watchList = watchList;
	}
}
