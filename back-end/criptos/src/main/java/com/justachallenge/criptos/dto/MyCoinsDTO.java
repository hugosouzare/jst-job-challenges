package com.justachallenge.criptos.dto;

/**
* Classe DTO para mostrar informações das coins de um usuário
**/
public class MyCoinsDTO {

	private String name;

	private String symbol;

	private String price;

	private String startWatchPrice;


	private String variation24Hr;
	
	

	public MyCoinsDTO(String name, String symbol, String price, String startWatchPrice, 
			String variation24Hr) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.price = price;
		this.startWatchPrice = startWatchPrice;
	
		this.variation24Hr = variation24Hr;
	}
	
	public MyCoinsDTO() {
		super();
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStartWatchPrice() {
		return startWatchPrice;
	}

	public void setStartWatchPrice(String startWatchPrice) {
		this.startWatchPrice = startWatchPrice;
	}


	public String getVariation24Hr() {
		return variation24Hr;
	}

	public void setVariation24Hr(String variation24Hr) {
		this.variation24Hr = variation24Hr;
	}

}
