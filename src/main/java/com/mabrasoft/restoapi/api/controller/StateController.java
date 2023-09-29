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

import com.mabrasoft.restoapi.domain.model.State;

import com.mabrasoft.restoapi.domain.service.StateService;



@RestController
@RequestMapping("/states")
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<State> restaurantList(){
		return stateService.list();
	}
	
	@GetMapping("/{stateId}")
	public ResponseEntity<State> stateByName(@PathVariable Long statetId){
		State state = stateService.search(statetId);
		return ResponseEntity.status(HttpStatus.FOUND).body(state);
	}
	
	@PostMapping
	public ResponseEntity<State> add(@RequestBody State state){
		State stateSave = stateService.add(state);
		return ResponseEntity.status(HttpStatus.CREATED).body(stateSave);
	}
	
	@DeleteMapping
	public ResponseEntity<State> remove(@RequestBody State state){
		 stateService.remove(state);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/{stateId}")
	public ResponseEntity<?> update(@PathVariable Long stateId, @RequestBody State state){
		State stateCurrent = stateService.update(stateId, state);
		return ResponseEntity.status(HttpStatus.OK).body(stateCurrent);
	}

}
