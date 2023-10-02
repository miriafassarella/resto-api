package com.mabrasoft.restoapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.State;

@Repository
public interface StateRepository  extends JpaRepository<State, Long>{
	
	

}
