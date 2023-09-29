package com.mabrasoft.restoapi.domain.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.mabrasoft.restoapi.domain.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	
}
