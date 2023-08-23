package com.mabrasoft.restoapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepository;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {
	
	@Autowired
	KitchenRepository kitchenRepository;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Kitchen> kitchenList(){
		return kitchenRepository.list();
	}
	
	@GetMapping("/{kitchenId}")
	public ResponseEntity<Kitchen> kitchenSearch(@PathVariable Long kitchenId){
		Kitchen kitchen =  kitchenRepository.search(kitchenId);
		 return ResponseEntity.status(HttpStatus.FOUND).body(kitchen);
	}
	
}