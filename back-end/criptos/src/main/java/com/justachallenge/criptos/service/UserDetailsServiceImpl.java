package com.justachallenge.criptos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.justachallenge.criptos.model.User;
import com.justachallenge.criptos.repository.UserRepository;
import com.justachallenge.criptos.security.UserSS;

/**
* Classe auxiliar de serviço do Spring Security
**/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userRepo.findByLogin(username)).orElseThrow(() -> new UsernameNotFoundException(username));
		
		return new UserSS(user.getUserId(), user.getLogin(), user.getPassword(), user.getProfiles());
	}
	

}
