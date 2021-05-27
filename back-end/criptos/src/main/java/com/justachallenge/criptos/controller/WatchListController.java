package com.justachallenge.criptos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justachallenge.criptos.dto.BasicCoinInfoDTO;
import com.justachallenge.criptos.dto.MyCoinsDTO;
import com.justachallenge.criptos.service.WatchListService;

@RestController
@RequestMapping(value = "/mywatchlist")
public class WatchListController {

	@Autowired
	WatchListService service;

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<BasicCoinInfoDTO> findCoin(@PathVariable String id) {
		BasicCoinInfoDTO coinInfo = service.findCoin(id);
		return ResponseEntity.ok().body(coinInfo);
	}

	@PostMapping(value = "/insert/{name}")
	public void insertCoin(@PathVariable String name) {
		service.insertCoinIntoWL(name);
	}

	@DeleteMapping(value = "/delete/{name}")
	public void deleteCoin(@PathVariable String name) {
		service.deleteCoin(name);

	}
	
	@GetMapping(value ="/mycoins") 
	public ResponseEntity<?> myCoins() {
		List<MyCoinsDTO> list = service.coinList();
		return ResponseEntity.ok().body(list);
	}

}
