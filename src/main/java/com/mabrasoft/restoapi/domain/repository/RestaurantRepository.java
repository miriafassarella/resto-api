package com.mabrasoft.restoapi.domain.repository;




import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Kitchen;
import com.mabrasoft.restoapi.domain.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	List<Restaurant> name(String name);
	
	List<Restaurant> freight(BigDecimal freight);
	
}
