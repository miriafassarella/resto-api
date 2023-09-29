package com.mabrasoft.restoapi.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mabrasoft.restoapi.domain.model.City;


public interface CityRepository extends JpaRepository<City, Long>{

	
}
