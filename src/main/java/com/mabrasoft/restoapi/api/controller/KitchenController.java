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

import com.mabrasoft.restoapi.domain.exception.EntityInUseException;
import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;
import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepository;
import com.mabrasoft.restoapi.domain.service.KitchenService;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {
	
	@Autowired
	KitchenRepository kitchenRepository;
	
	@Autowired
	KitchenService kitchenService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Kitchen> kitchenList(){
		return kitchenService.kitchenList();
	}
	
	@GetMapping("/{kitchenId}")
	public ResponseEntity<Kitchen> kitchenSearch(@PathVariable Long kitchenId){
	
		Kitchen kitchen = kitchenService.search(kitchenId);
		 return ResponseEntity.status(HttpStatus.FOUND).body(kitchen);
	}
	
	@GetMapping("/byname")
	public List<Kitchen> findName(String name){
		return kitchenService.findName(name);
	}
	
	@PostMapping()
	public ResponseEntity<Kitchen> kitchenAdd(@RequestBody Kitchen kitchen){
		kitchen = kitchenService.add(kitchen);
		return ResponseEntity.status(HttpStatus.CREATED).body(kitchen);
	}
	@DeleteMapping("/{kitchenId}")
	public ResponseEntity<?> kitchenRemove(@PathVariable Long kitchenId){
			try {
				kitchenService.remove(kitchenId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch(EntityNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}catch(EntityInUseException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
		}
	@PutMapping("/{kitchenId}")
	public ResponseEntity<?> kitchenUpdate(@PathVariable Long kitchenId, @RequestBody Kitchen kitchen){
		try {
			kitchenService.update(kitchenId, kitchen);
			return ResponseEntity.status(HttpStatus.OK).body(kitchen);
		}catch(EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
