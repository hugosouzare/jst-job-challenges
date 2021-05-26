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
import com.justachallenge.criptos.service.exception.ObjNotFoundException;

import javassist.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	WatchListRepository watchRepo;

	public void create(User us) {

		if (!Optional.ofNullable(userRepo.findByLogin(us.getLogin())).isEmpty()) {
			throw new BadRequestException("Username already exists");
		}

		userRepo.save(us);
	}

	public User searchUser(String id) {
		Long id1 = Long.parseLong(id);

		User user = userRepo.findById(id1).orElseThrow(() -> new ObjNotFoundException("User not found"));

		return user;
	}

	public void deleteUser(String id) {
		Long id1 = Long.parseLong(id);
		Optional.ofNullable(userRepo.findById(id1).orElseThrow(() -> new ObjNotFoundException("User not found")));
		userRepo.deleteById(id1);
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
