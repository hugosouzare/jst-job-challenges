package com.justachallenge.criptos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justachallenge.criptos.dto.RegisterUserDTO;
import com.justachallenge.criptos.dto.UserInfoDTO;
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
		service.create(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PreAuthorize ("hasAnyRole('ADMIN')")
	@GetMapping(value = "/userinfo/{id}")
	public ResponseEntity<User> userInfoById(@PathVariable String id) {
		User user = service.searchUser(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/myinfo")
	public ResponseEntity<UserInfoDTO> userInfo() {
		UserInfoDTO user = service.userInfo();
		return ResponseEntity.ok().body(user);
	}
	
	@PreAuthorize ("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/deleteuser/{id}")
	public void deleteUser(@PathVariable String id) {
		service.deleteUserById(id);
	}
	

	@PutMapping(value = "/updateinfos")
	public ResponseEntity<User> updateUserInfo(@Valid @RequestBody RegisterUserDTO userInfos) {
		User user = service.update(userInfos);
		
		return ResponseEntity.ok().body(user);
	}
	
	
}
