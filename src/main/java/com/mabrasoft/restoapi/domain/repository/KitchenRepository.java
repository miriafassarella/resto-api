package com.mabrasoft.restoapi.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Kitchen;

@Repository
public interface KitchenRepository {

	 
	List<Kitchen> list();
	List<Kitchen> byName(String name);
	Kitchen search(Long id);
	Kitchen add(Kitchen kitchen);
	void remove(Long id);
}
