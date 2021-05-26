package com.justachallenge.criptos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.model.Address;
import com.justachallenge.criptos.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addrepo;
	
	public void insertAddress(Address ad) {
		
	}
}
