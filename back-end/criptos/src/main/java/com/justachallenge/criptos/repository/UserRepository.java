package com.justachallenge.criptos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justachallenge.criptos.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
