package com.justachallenge.criptos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justachallenge.criptos.model.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList,Long> {

}
