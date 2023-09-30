package com.mabrasoft.restoapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;
import com.mabrasoft.restoapi.domain.model.Restaurant;
import com.mabrasoft.restoapi.domain.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public List<Restaurant> list(){
		return restaurantRepository.findAll();
	}
	
	public Restaurant search(Long restaurantId){
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		return restaurant.get();
	}
	
	public Restaurant add(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	public void remove(Long restaurantId) {
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		restaurantRepository.delete(restaurant.get());
	}
	
	public Restaurant update(Long restaurantId, Restaurant restaurant) {
		Optional<Restaurant> restaurantCurrent = restaurantRepository.findById(restaurantId);
		
		if(restaurantCurrent.isPresent()) {
			BeanUtils.copyProperties(restaurant, restaurantCurrent.get(), "id");
			return restaurantRepository.save(restaurantCurrent.get());
		}
		throw new EntityNotFoundException(String.format("The code %d restaurant does not exist", restaurantId));
	}
}
