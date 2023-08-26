package com.mabrasoft.restoapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mabrasoft.restoapi.domain.model.Restaurant;
import com.mabrasoft.restoapi.domain.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Restaurant> restaurantList(){
		return restaurantRepository.list();
	}
	
	@GetMapping("/by-name")
	public List<Restaurant> restaurantByName(@RequestParam("name") String name){
		return restaurantRepository.byName(name);
	}
}
