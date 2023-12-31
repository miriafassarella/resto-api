package com.mabrasoft.restoapi.domain.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
		
	List<City> findByNameContaining(String name);
}
