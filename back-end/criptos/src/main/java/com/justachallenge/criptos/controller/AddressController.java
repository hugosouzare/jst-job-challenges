package com.justachallenge.criptos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justachallenge.criptos.dto.AddressDTO;
import com.justachallenge.criptos.model.Address;
import com.justachallenge.criptos.service.AddressService;

@RestController
@RequestMapping(value ="/address")
public class AddressController {

	@Autowired
	AddressService addservice;

	@PostMapping(value ="/insert")
	public ResponseEntity<Address> insertAddress(@Valid @RequestBody AddressDTO addDTO) {
		Address address = addservice.addresFromDTO(addDTO);
		addservice.create(address);
		
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}
}
