package com.mabrasoft.restoapi.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class KitchenRepositoryImpl implements KitchenRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Kitchen> list() {
		
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
	}

	@Override
	public Kitchen search(Long id) {
		
		return manager.find(Kitchen.class, id);
	}

	@Transactional
	@Override
	public Kitchen add(Kitchen kitchen) {
		
		return manager.merge(kitchen);
	}

	@Transactional
	@Override
	public void remove(Long id) {
		Kitchen kitchen = search(id);
		manager.remove(kitchen);
		
	}

}
