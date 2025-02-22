package com.justachallenge.criptos.dto;

/**
* Classe DTO para coletar as informações da API da CoinCap
**/
public class DataDTO {

private String id;
	
	private String rank;
	
	private String symbol;
	
	private String name;
	
	private String supply;
	
	private String maxSupply;
	
	private String marketCapUsd;
	
	private String volumeUsd24Hr;
	
	private String priceUsd;
	
	private String changePercent24Hr;
	
	private String vwap24Hr;
	
	

	public DataDTO(String id, String rank, String symbol, String name, String supply, String maxSupply,
			String marketCapUsd, String volumeUsd24Hr, String priceUsd, String changePercente24Hr, String vwap24Hr) {
		super();
		this.id = id;
		this.rank = rank;
		this.symbol = symbol;
		this.name = name;
		this.supply = supply;
		this.maxSupply = maxSupply;
		this.marketCapUsd = marketCapUsd;
		this.volumeUsd24Hr = volumeUsd24Hr;
		this.priceUsd = priceUsd;
		this.changePercent24Hr = changePercente24Hr;
		this.vwap24Hr = vwap24Hr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public String getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(String maxSupply) {
		this.maxSupply = maxSupply;
	}

	public String getMarketCapUsd() {
		return marketCapUsd;
	}

	public void setMarketCapUsd(String marketCapUsd) {
		this.marketCapUsd = marketCapUsd;
	}

	public String getVolumeUsd24Hr() {
		return volumeUsd24Hr;
	}

	public void setVolumeUsd24Hr(String volumeUsd24Hr) {
		this.volumeUsd24Hr = volumeUsd24Hr;
	}

	public String getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(String priceUsd) {
		this.priceUsd = priceUsd;
	}

	public String getChangePercent24Hr() {
		return changePercent24Hr;
	}

	public void setChangePercente24Hr(String changePercente24Hr) {
		this.changePercent24Hr = changePercente24Hr;
	}

	public String getVwap24Hr() {
		return vwap24Hr;
	}

	public void setVwap24Hr(String vwap24Hr) {
		this.vwap24Hr = vwap24Hr;
	}

}
