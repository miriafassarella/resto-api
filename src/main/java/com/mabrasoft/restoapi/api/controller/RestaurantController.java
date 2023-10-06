package com.mabrasoft.restoapi.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mabrasoft.restoapi.domain.model.Restaurant;

import com.mabrasoft.restoapi.domain.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Restaurant> restaurantList(){
		return restaurantService.list();
	}
	
	@GetMapping("/byname")
	public List<Restaurant> byName(String name){
		return restaurantService.byName(name);
	}
	
	@GetMapping("/byfreight")
	public List<Restaurant> byFreight(BigDecimal freight){
		return restaurantService.byFreight(freight);
	}
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> restaurantByName(@PathVariable Long restaurantId){
		Restaurant restaurant = restaurantService.search(restaurantId);
		return ResponseEntity.status(HttpStatus.FOUND).body(restaurant);
	}
	
	@PostMapping
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant){
		Restaurant restaurantSave = restaurantService.add(restaurant);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantSave);
	}
	
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> remove(@PathVariable Long restaurantId){
		 restaurantService.remove(restaurantId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/{restaurantId}")
	public ResponseEntity<?> update(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant){
		Restaurant restaurantCurrent = restaurantService.update(restaurantId, restaurant);
		return ResponseEntity.status(HttpStatus.OK).body(restaurantCurrent);
	}
}
