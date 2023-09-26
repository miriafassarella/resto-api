package com.mabrasoft.restoapi.infrastructure.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class KitchenRepositoyImpl implements KitchenRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Kitchen> list() {
		
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
	}

	@Override
	public List<Kitchen> byName(String name) {
		
		return manager.createQuery("from Kitchen where name like :name", Kitchen.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
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
