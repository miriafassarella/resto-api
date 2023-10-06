package com.mabrasoft.restoapi.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.repository.KitchenRepositoryQueries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Repository
public class KitchenRepositoryImpl implements KitchenRepositoryQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Kitchen> find(String name, BigDecimal freight) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Kitchen> criteria = builder.createQuery(Kitchen.class);
		
		criteria.from(Kitchen.class); //from kitchen
		
		TypedQuery<Kitchen> query =  manager.createQuery(criteria);
		return query.getResultList();
	}

}
