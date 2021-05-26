package com.justachallenge.criptos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.justachallenge.criptos.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	@Transactional(readOnly = true)
	public User findByLogin(String login);
	
	@Transactional(readOnly = true)
	public User findByEmail(String email);
}
