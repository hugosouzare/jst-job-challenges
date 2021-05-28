package com.justachallenge.criptos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justachallenge.criptos.dto.BasicCoinInfoDTO;
import com.justachallenge.criptos.dto.MyCoinsDTO;
import com.justachallenge.criptos.service.WatchListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/mywatchlist")
@Api(value = "API WatchLists")
@CrossOrigin(origins = "*")
public class WatchListController {

	@Autowired
	WatchListService service;

	/**
	* Retorna informações de criptmoedas através da API do CoinCap, apenas para consulta.
	**/
	@GetMapping(value = "/find/{id}")
	@ApiOperation(value = "Return cryptocurrency infos by id")
	public ResponseEntity<BasicCoinInfoDTO> findCoin(@PathVariable String id) {
		BasicCoinInfoDTO coinInfo = service.findCoin(id);
		return ResponseEntity.ok().body(coinInfo);
	}

	/**
	* Insere uma criptomoeda na watchlist do usuário logado através do nome da cripto
	**/
	@PostMapping(value = "/insert/{name}")
	@ApiOperation(value = "Inserts a cryptocurrency into user watchlist")
	public void insertCoin(@PathVariable String name) {
		service.insertCoinIntoWL(name);
	}

	/**
	* Deleta uma criptomoeda na watchlist do usuário logado
	**/
	@ApiOperation(value = "Delete a cryptocurency from user watchlist")
	@DeleteMapping(value = "/delete/{name}")
	public void deleteCoin(@PathVariable String name) {
		service.deleteCoin(name);

	}
	
	/**
	* Retorna as todas as criptomoedas da watchlist do usuário logado
	**/
	@GetMapping(value ="/mycoins") 
	@ApiOperation(value = "Returns the user watchlist")
	public ResponseEntity<?> myCoins() {
		List<MyCoinsDTO> list = service.coinList();
		return ResponseEntity.ok().body(list);
	}

}
