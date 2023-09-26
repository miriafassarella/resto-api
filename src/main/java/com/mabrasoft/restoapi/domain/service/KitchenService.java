package com.mabrasoft.restoapi.domain.service;


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
	KitchenRepository kitchenRepository;
	
	public Kitchen add(Kitchen kitchen) {
		return kitchenRepository.add(kitchen);
	}
	
	public void remove(Long kitcheId) {
		Kitchen kitchen = kitchenRepository.search(kitcheId);

		try {
			if(kitchen != null) {
				kitchenRepository.remove(kitcheId);
			}else {
				throw new EntityNotFoundException(String.format("Code entity %d not found!", kitcheId));
			}
		}catch(DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Entity code %d is in use!", kitcheId));
		}
		}
	
	public Kitchen update(Long kitchenId, Kitchen kitchen) {
		Kitchen currentKitchen = kitchenRepository.search(kitchenId);
		
		if(currentKitchen != null) {
			kitchen.setId(kitchenId);
			BeanUtils.copyProperties(kitchen, currentKitchen);
			return kitchenRepository.add(kitchen);
		}
		throw new EntityNotFoundException(String.format("Code entity %d not found!", kitchenId));
	}
			
}
