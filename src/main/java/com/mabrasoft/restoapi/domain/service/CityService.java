package com.mabrasoft.restoapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;
import com.mabrasoft.restoapi.domain.model.City;

import com.mabrasoft.restoapi.domain.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	public List<City> list(){
		return cityRepository.findAll();
	}
	
	public City search(Long cityId){
		Optional<City> city = cityRepository.findById(cityId);
		return city.get();
	}
	
	public City add(City city) {
		return cityRepository.save(city);
	}
	
	public void remove(Long cityId) {
		Optional<City> city = cityRepository.findById(cityId);
		cityRepository.delete(city.get());
	}
	
	public City update(Long cityId, City city) {
		Optional<City> cityCurrent = cityRepository.findById(cityId);
		
		if(cityCurrent.isPresent()) {
			BeanUtils.copyProperties(city, cityCurrent.get(), "id");
			return cityRepository.save(cityCurrent.get());
		}
		throw new EntityNotFoundException(String.format("The code %d city does not exist", cityId));
	}

}
