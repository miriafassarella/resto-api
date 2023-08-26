package com.mabrasoft.restoapi.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Restaurant;
import com.mabrasoft.restoapi.domain.repository.RestaurantRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Restaurant> list() {
		
		return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
	}

	@Override
	public List<Restaurant> byName(String name) {
		
		return manager.createQuery("from Restaurant where name like :name", Restaurant.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
	}

	@Override
	public Restaurant search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Restaurant add(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
