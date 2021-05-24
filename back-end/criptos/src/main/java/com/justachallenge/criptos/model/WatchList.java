package com.justachallenge.criptos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class WatchList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long watchListId;
	
	@OneToMany(mappedBy = "watchList", cascade=CascadeType.PERSIST, orphanRemoval = true)
	private List<CryptoCurrency> cryptoList = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private User user;
	

}
