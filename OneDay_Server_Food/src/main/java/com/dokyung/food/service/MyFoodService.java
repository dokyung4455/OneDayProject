package com.dokyung.food.service;

import java.util.List;

import com.dokyung.food.model.FoodDTO;

public interface MyFoodService {
	
	public List<FoodDTO> SelectAll();
	public List<FoodDTO> FindByName(String fd_name);
	public String FindByDate(String fd_date);
	public void delete();

}
