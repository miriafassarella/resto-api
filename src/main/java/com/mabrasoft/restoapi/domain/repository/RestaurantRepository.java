package com.mabrasoft.restoapi.domain.repository;

import java.util.List;

import com.mabrasoft.restoapi.domain.model.Restaurant;

public interface RestaurantRepository {

	List<Restaurant> list();
	List<Restaurant> byName(String name);
	Restaurant search(Long id);
	Restaurant add(Restaurant restaurant);
	void remove(Long id);
}
