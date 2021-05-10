package com.dokyung.food.service;

import java.util.List;

import com.dokyung.food.model.FoodSearchDTO;

public interface FoodService {
	
	public List<FoodSearchDTO> SelectAll();
	public void	FindByName();
	public void insert();
	public void delete();
	
	

}
