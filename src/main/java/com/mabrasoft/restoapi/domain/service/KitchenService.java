package com.mabrasoft.restoapi.domain.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityInUseException;
import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;
import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepository;

@Service
public class KitchenService {

	@Autowired
	private KitchenRepository kitchenRepository;
	
	public List<Kitchen> kitchenList(){
		return kitchenRepository.findAll();
	}
	
	public Kitchen search(Long kitchenId) {
		Optional<Kitchen> kitchen = kitchenRepository.findById(kitchenId);
		return kitchen.get();
	}
	public List<Kitchen> findName(String name) {
		return kitchenRepository.findByNameContaining(name);
	}
	
	public Kitchen add(Kitchen kitchen) {
		return kitchenRepository.save(kitchen);
	}
	
	public void remove(Long kitchenId) {
		Optional<Kitchen> kitchen = kitchenRepository.findById(kitchenId);

		try {
			if(kitchen.get() != null) {
				kitchenRepository.delete(kitchen.get());;
			}else {
				throw new EntityNotFoundException(String.format("Code entity %d not found!", kitchenId));
			}
		}catch(DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Entity code %d is in use!", kitchenId));
		}
		}
	
	public Kitchen update(Long kitchenId, Kitchen kitchen) {
		Optional<Kitchen> currentkitchen = kitchenRepository.findById(kitchenId);
		
		if(currentkitchen.get() != null) {
			kitchen.setId(kitchenId);
			BeanUtils.copyProperties(kitchen, currentkitchen);
			return kitchenRepository.save(kitchen);
		}
		throw new EntityNotFoundException(String.format("Code entity %d not found!", kitchenId));
	}
			
}
