package com.justachallenge.criptos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.justachallenge.criptos.model.CryptoCurrency;



public interface CryptocurrencyRepository extends JpaRepository<CryptoCurrency,Long>{

	@Transactional(readOnly = true)
	public CryptoCurrency findByName(String name);
}
