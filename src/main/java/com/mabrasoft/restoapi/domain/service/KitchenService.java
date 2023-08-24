package com.mabrasoft.restoapi.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;
import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepository;

@Service
public class KitchenService {

	@Autowired
	KitchenRepository kitchenRepository;
	
	public Kitchen add(Kitchen kitchen) {
		return kitchenRepository.add(kitchen);
	}
	
	public void remove(Long kitcheId) {
		try {
			kitchenRepository.remove(kitcheId);
		}catch(IllegalArgumentException e) {
			throw new EntityNotFoundException(String.format("Code entity %d not found!", kitcheId));
		}
	}
	
	public Kitchen update(Long kitchenId, Kitchen kitchen) {
		Kitchen currentKitchen = kitchenRepository.search(kitchenId);
		
		if(currentKitchen != null) {
			kitchen.setId(kitchenId);
			BeanUtils.copyProperties(kitchen, currentKitchen);
			return kitchenRepository.add(currentKitchen);
		}
		throw new EntityNotFoundException(String.format("Code entity %d not found!", kitchenId));
	}
			
}
