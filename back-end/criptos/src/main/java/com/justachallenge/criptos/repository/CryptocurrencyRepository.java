package com.justachallenge.criptos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justachallenge.criptos.model.CryptoCurrency;


public interface CryptocurrencyRepository extends JpaRepository<CryptoCurrency,Long>{

}
