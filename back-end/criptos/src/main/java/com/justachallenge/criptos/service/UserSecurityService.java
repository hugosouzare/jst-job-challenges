package com.justachallenge.criptos.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.justachallenge.criptos.security.UserSS;

/**
* Classe auxiliar de serviço do Spring Security
**/
public class UserSecurityService {

	public static UserSS authenticated() {
		try {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		
		catch (Exception e) {
			return null;
		}
	}
}
