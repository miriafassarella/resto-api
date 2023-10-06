package com.mabrasoft.restoapi.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Kitchen;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long>, KitchenRepositoryQueries{

	List<Kitchen> name(String name); 
	
}
