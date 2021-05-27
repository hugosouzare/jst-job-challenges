package com.justachallenge.criptos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.dto.BasicCoinInfoDTO;
import com.justachallenge.criptos.model.CryptoCurrency;
import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.repository.CryptocurrencyRepository;
import com.justachallenge.criptos.repository.UserRepository;
import com.justachallenge.criptos.security.UserSS;
import com.justachallenge.criptos.service.exception.BadRequestException;

@Service
public class WatchListService {

	@Autowired
	CoinCapService coinService;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CryptocurrencyRepository cryptoRepo;

	public BasicCoinInfoDTO findCoin(String id) {
		BasicCoinInfoDTO coinInfo = coinService.searchCoin(id);

		return coinInfo;
	}

	public void insertCoinIntoWL(String id) {
        
		BasicCoinInfoDTO coinInfo = findCoin(id);
		
		UserSS userSec = UserSecurityService.authenticated();

		Optional.ofNullable(userRepo.findById(userSec.getId()))
				.orElseThrow(() -> new BadRequestException("User not found"));

		CryptoCurrency crypto = new CryptoCurrency(coinInfo.getData().getName(), coinInfo.getData().getSymbol(),
				coinInfo.getData().getPriceUsd(), userRepo.findById(userSec.getId()).orElseThrow().getWatchList());
		
		cryptoRepo.save(crypto);

	}
}
