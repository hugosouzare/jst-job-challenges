package com.justachallenge.criptos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.dto.RegisterUserDTO;
import com.justachallenge.criptos.dto.UserInfoDTO;
import com.justachallenge.criptos.model.PersonalInfo;
import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.model.WatchList;
import com.justachallenge.criptos.repository.UserRepository;
import com.justachallenge.criptos.repository.WatchListRepository;
import com.justachallenge.criptos.security.UserSS;
import com.justachallenge.criptos.service.exception.BadRequestException;
import com.justachallenge.criptos.service.exception.ObjNotFoundException;

/**
* Classe de serviço de Usuários
* 
**/
@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	UserRepository userRepo;

	@Autowired
	WatchListRepository watchRepo;

	/**
	* Método para inserção de usuários no banco de dados
	**/
	public void create(User us) {

		if (!Optional.ofNullable(userRepo.findByLogin(us.getLogin())).isEmpty()) {
			throw new BadRequestException("Username already exists");
		}

		userRepo.save(us);
	}

	/**
	* Método para busca de usuários através do ID
	**/
	public User searchUser(String id) {
		Long id1 = Long.parseLong(id);

		User user = userRepo.findById(id1).orElseThrow(() -> new ObjNotFoundException("User not found"));

		return user;
	}

	/**
	* Método para retornar um UserInfoDTO de um usuário logado, necessário para o endpoint de informações do usuário
	**/
	public UserInfoDTO userInfo() {
		UserSS user = UserSecurityService.authenticated();

		User user2 = userRepo.findById(user.getId()).orElseThrow();

		UserInfoDTO userinfo = new UserInfoDTO(user2.getLogin(), user2.getEmail(), user2.getPersonalInfo());

		return userinfo;
	}

	/**
	* Método para deleção de usuários no banco de dados
	**/
	public void deleteUserById(String id) {

		Long id1 = Long.parseLong(id);

		Optional.ofNullable(userRepo.findById(id1).orElseThrow(() -> new ObjNotFoundException("User not found")));

		userRepo.deleteById(id1);
	}

	/**
	* Retorna um User através de um DTO de registro
	**/
	public User userFromDTO(RegisterUserDTO userdto) {

		WatchList watch = new WatchList();

		PersonalInfo personal = new PersonalInfo(userdto.getName(), userdto.getLastName(), userdto.getPhone());

		User us = new User(userdto.getUsername(), passEncoder.encode(userdto.getPassword()), userdto.getEmail(), watch,
				personal);

		personal.setUser(us);
		watch.setUser(us);

		return us;
	}

	/**
	* Método para atualização de usuários, retornando um user para leitura no endpoint de atualização
	* 
	**/
	public User update(RegisterUserDTO userdto) {

		UserSS userSec = UserSecurityService.authenticated();

		User user = userRepo.findById(userSec.getId()).orElseThrow(() -> new BadRequestException("User not found"));

		user.setEmail(userdto.getEmail());
		user.setLogin(userdto.getUsername());
		user.setPassword(passEncoder.encode(userdto.getPassword()));
		user.getPersonalInfo().setName(userdto.getName());
		user.getPersonalInfo().setLastName(userdto.getLastName());
		user.getPersonalInfo().setPhone(userdto.getPhone());

		userRepo.save(user);
		
		return user;
	}
}
