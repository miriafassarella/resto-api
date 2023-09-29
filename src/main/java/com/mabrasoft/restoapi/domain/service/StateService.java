package com.mabrasoft.restoapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;

import com.mabrasoft.restoapi.domain.model.State;
import com.mabrasoft.restoapi.domain.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	StateRepository stateRepositoy;
	
	public List<State> list(){
		return stateRepositoy.findAll();
	}
	
	public State search(Long stateId){
		Optional<State> state = stateRepositoy.findById(stateId);
		return state.get();
	}
	
	public State add(State state) {
		return stateRepositoy.save(state);
	}
	
	public void remove(State state) {
		stateRepositoy.delete(state);
	}
	
	public State update(Long stateId, State state) {
		Optional<State> stateCurrent = stateRepositoy.findById(stateId);
		
		if(stateCurrent.isPresent()) {
			BeanUtils.copyProperties(state, stateCurrent.get(), "id");
			return stateRepositoy.save(stateCurrent.get());
		}
		throw new EntityNotFoundException(String.format("The code %d state does not exist", stateId));
	}
}
