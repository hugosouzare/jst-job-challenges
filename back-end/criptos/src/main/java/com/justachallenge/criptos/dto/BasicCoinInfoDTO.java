package com.justachallenge.criptos.dto;

/**
* Classe DTO para coletar as informações da API da CoinCap
**/
public class BasicCoinInfoDTO {
	
	private DataDTO data;
	
	private Long timestamp;
	
	

	public BasicCoinInfoDTO(DataDTO data, Long timestamp) {
		super();
		this.data = data;
		this.timestamp = timestamp;
	}

	public DataDTO getData() {
		return data;
	}

	public void setData(DataDTO data) {
		this.data = data;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
}
