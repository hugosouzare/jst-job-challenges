package com.justachallenge.criptos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justachallenge.criptos.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
