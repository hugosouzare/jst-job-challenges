package com.justachallenge.criptos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justachallenge.criptos.dto.RegisterUserDTO;
import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.service.UserService;

@RestController
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping(value = "/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUserDTO register) {
		User user = service.userFromDTO(register);
		service.registerUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
}
