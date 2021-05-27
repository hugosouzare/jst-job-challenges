package com.justachallenge.criptos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.dto.BasicCoinInfoDTO;
import com.justachallenge.criptos.dto.MyCoinsDTO;
import com.justachallenge.criptos.model.CryptoCurrency;
import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.repository.CryptocurrencyRepository;
import com.justachallenge.criptos.repository.UserRepository;
import com.justachallenge.criptos.security.UserSS;
import com.justachallenge.criptos.service.exception.BadRequestException;

/**
* Classe de serviço de WatchLists
* 
**/
@Service
public class WatchListService {

	@Autowired
	CoinCapService coinService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	CryptocurrencyRepository cryptoRepo;

	/**
	* Busca informações de uma criptomoeda pela API do CoinCap
	**/
	public BasicCoinInfoDTO findCoin(String id) {
		BasicCoinInfoDTO coinInfo = coinService.searchCoin(id);

		return coinInfo;
	}

	/**
	* Insere uma criptomoeda na watchlist de um usuário logado através do id/nome da criptomoeda
	**/
	public void insertCoinIntoWL(String id) {
		UserSS userSec = UserSecurityService.authenticated();

		BasicCoinInfoDTO coinInfo = findCoin(id);

		User user = userRepo.findById(userSec.getId()).orElseThrow(() -> new BadRequestException("User not found"));

		if (user.getWatchList().getCryptoList().contains(cryptoRepo.findByName(coinInfo.getData().getId()))) {
			throw new BadRequestException("You already have " + coinInfo.getData().getName() + " on your watchlist");
		}

		CryptoCurrency crypto = new CryptoCurrency(coinInfo.getData().getId(), coinInfo.getData().getSymbol(),
				coinInfo.getData().getPriceUsd(), user.getWatchList());

		cryptoRepo.save(crypto);

	}

	/**
	* Deleta uma criptomoeda da watchlist
	**/
	public void deleteCoin(String name) {
		UserSS userSec = UserSecurityService.authenticated();
        
		User user = userRepo.findById(userSec.getId()).orElseThrow(() -> new BadRequestException("User not found"));
	
		if (!user.getWatchList().getCryptoList().contains(cryptoRepo.findByName(name))) {
			throw new BadRequestException("You don't have " + name + " on your watchlist");
		}

		CryptoCurrency crypto = cryptoRepo.findByName(name);

		cryptoRepo.deleteById(crypto.getId());

	}

	/**
	* Retorna uma lista com todas as criptomoedas do usuário
	**/
	public List<MyCoinsDTO> coinList() {

		UserSS userSec = UserSecurityService.authenticated();

		User user = userRepo.findById(userSec.getId()).orElseThrow(() -> new BadRequestException("User not found"));

		List<CryptoCurrency> list = user.getWatchList().getCryptoList();

		List<MyCoinsDTO> myList = new ArrayList<>();

		for (CryptoCurrency c : list) {

			MyCoinsDTO myCoin = new MyCoinsDTO();
			BasicCoinInfoDTO coinInfo = findCoin(c.getName());
			myCoin.setName(c.getName());
			myCoin.setPrice(coinInfo.getData().getPriceUsd());
			myCoin.setStartWatchPrice(c.getStartWatchPrice());
			myCoin.setVariation24Hr(coinInfo.getData().getChangePercent24Hr());
			myCoin.setSymbol(c.getSymbol());

			myList.add(myCoin);

		}

		return myList;

	}
}
