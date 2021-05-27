package com.justachallenge.criptos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.justachallenge.criptos.dto.ViaCepDTO;

/**
* Classe para consumir a API do viacep
**/
@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepService {

	@GetMapping("{cep}/json")
	public ViaCepDTO buscaCep(@PathVariable("cep") String cep);
}
