package com.justachallenge.criptos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.dto.AddressDTO;
import com.justachallenge.criptos.dto.ViaCepDTO;
import com.justachallenge.criptos.model.Address;
import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.repository.AddressRepository;
import com.justachallenge.criptos.repository.UserRepository;
import com.justachallenge.criptos.security.UserSS;
import com.justachallenge.criptos.service.exception.BadRequestException;

@Service
public class AddressService {

	@Autowired
	AddressRepository addrepo;

	@Autowired
	ViaCepService viacepserv;
	
	@Autowired
	UserRepository userRepo;

	public void create(Address ad) {

		addrepo.save(ad);
	}

	public Address addresFromDTO(AddressDTO adDTO) {
		
		UserSS userSec = UserSecurityService.authenticated();

		User user = userRepo.findById(userSec.getId()).orElseThrow(() -> new BadRequestException("User not found"));
		
		ViaCepDTO viacep = viacepserv.buscaCep(adDTO.getZipCode());

		if (viacep.getErro() != null) {
			throw new BadRequestException("The zip code: " + viacep.getCep() + " was not found or doesn't exists");
		}

		Address add = new Address(viacep.getLocalidade(), adDTO.getZipCode(), adDTO.getStreet(), viacep.getUf(),
				adDTO.getNumber(), adDTO.getOptionalAddress(), user.getPersonalInfo());
		
		return add;
	}
}
