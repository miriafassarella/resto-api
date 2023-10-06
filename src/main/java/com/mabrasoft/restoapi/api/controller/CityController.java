package com.mabrasoft.restoapi.api.controller;

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

import com.mabrasoft.restoapi.domain.model.City;

import com.mabrasoft.restoapi.domain.service.CityService;


@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	CityService cityService;
	

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<City> cityList(){
		return cityService.list();
	}
	
	@GetMapping("/byname")
	public List<City> byName(String name){
		return cityService.byname(name);
	}
	
	@GetMapping("/{cityId}")
	public ResponseEntity<City> cityByName(@PathVariable Long cityId){
		City city = cityService.search(cityId);
		return ResponseEntity.status(HttpStatus.FOUND).body(city);
	}
	
	@PostMapping
	public ResponseEntity<City> add(@RequestBody City city){
		City citySave = cityService.add(city);
		return ResponseEntity.status(HttpStatus.CREATED).body(citySave);
	}
	
	@DeleteMapping("/{cityId}")
	public ResponseEntity<City> remove(@PathVariable Long cityId){
		cityService.remove(cityId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/{cityId}")
	public ResponseEntity<?> update(@PathVariable Long cityId, @RequestBody City city){
		City cityCurrent = cityService.update(cityId, city);
		return ResponseEntity.status(HttpStatus.OK).body(cityCurrent);
	}
}
