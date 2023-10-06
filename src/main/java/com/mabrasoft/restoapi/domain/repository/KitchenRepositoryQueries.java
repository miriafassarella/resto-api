package com.mabrasoft.restoapi.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.mabrasoft.restoapi.domain.model.Kitchen;

public interface KitchenRepositoryQueries {

	List<Kitchen> find(String name, BigDecimal freight);
}
