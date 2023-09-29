package com.mabrasoft.restoapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mabrasoft.restoapi.domain.model.State;

public interface StateRepository  extends JpaRepository<State, Long>{
	
	

}
