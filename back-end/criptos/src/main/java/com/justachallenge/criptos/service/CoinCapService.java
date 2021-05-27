package com.justachallenge.criptos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.justachallenge.criptos.dto.BasicCoinInfoDTO;

@FeignClient(url = "https://api.coincap.io/v2/", name = "coincap")
public interface CoinCapService {

	@GetMapping("/assets/{id}")
	public BasicCoinInfoDTO searchCoin(@PathVariable("id") String id);
}
