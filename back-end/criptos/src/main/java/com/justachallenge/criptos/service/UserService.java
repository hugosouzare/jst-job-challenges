package com.justachallenge.criptos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.dto.RegisterUserDTO;
import com.justachallenge.criptos.model.PersonalInfo;
import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.model.WatchList;
import com.justachallenge.criptos.repository.UserRepository;
import com.justachallenge.criptos.repository.WatchListRepository;
import com.justachallenge.criptos.service.exception.BadRequestException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	WatchListRepository watchRepo;

	public void registerUser(User us) {

		if (!Optional.ofNullable(userRepo.findByLogin(us.getLogin())).isEmpty()) {
			throw new BadRequestException("Username already exists");
		}

		userRepo.save(us);
	}

	public User userFromDTO(RegisterUserDTO userdto) {

		WatchList watch = new WatchList();

		PersonalInfo personal = new PersonalInfo(userdto.getName(), userdto.getLastName(), userdto.getPhone());

		User us = new User(userdto.getUsername(), userdto.getPassword(), userdto.getEmail(), watch, personal);

		personal.setUser(us);
		watch.setUser(us);

		return us;
	}
}
