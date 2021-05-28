package com.justachallenge.criptos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/")
@Api(value = "API Usuários")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService service;
	
	/**
	* Registra um usuário
	**/
	@PostMapping(value = "/register")
	@ApiOperation(value = "Register an user")
	public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUserDTO register) {
		User user = service.userFromDTO(register);
		service.create(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	/**
	* Retorna as informações de um usuário pelo ID, apenas para usuários com permissão nível ADMIN
	**/
	
	@PreAuthorize ("hasAnyRole('ADMIN')")
	@GetMapping(value = "/userinfo/{id}")
	@ApiOperation(value = "Returns user infos by user id")
	public ResponseEntity<User> userInfoById(@PathVariable String id) {
		User user = service.searchUser(id);
		return ResponseEntity.ok().body(user);
	}
	
	/**
	* Retorna as informações do usuário logado
	**/
	@GetMapping(value = "/myinfo")
	@ApiOperation(value = "Returns user infos")
	public ResponseEntity<UserInfoDTO> userInfo() {
		UserInfoDTO user = service.userInfo();
		return ResponseEntity.ok().body(user);
	}
	
	/**
	* Deleta um usuário pelo id, apenas para usuários com permissão nível ADMIN
	**/
	@PreAuthorize ("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Delete an user")
	@DeleteMapping(value = "/deleteuser/{id}")
	public void deleteUser(@PathVariable String id) {
		service.deleteUserById(id);
	}
	

	/**
	* Atualiza um usuário
	**/
	@PutMapping(value = "/updateinfos")
	@ApiOperation(value = "Update an user")
	public ResponseEntity<User> updateUserInfo(@Valid @RequestBody RegisterUserDTO userInfos) {
		User user = service.update(userInfos);
		
		return ResponseEntity.ok().body(user);
	}
	
	
}
