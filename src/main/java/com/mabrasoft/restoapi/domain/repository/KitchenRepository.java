package com.mabrasoft.restoapi.domain.repository;

import java.util.List;

import com.mabrasoft.restoapi.domain.model.Kitchen;

public interface KitchenRepository {

	 List<Kitchen> list();
	 Kitchen search(Long id);
	 Kitchen add(Kitchen kitchen);
	 void remove(Long id);
}