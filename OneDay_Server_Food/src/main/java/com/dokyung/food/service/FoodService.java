package com.dokyung.food.service;

import java.util.List;

import com.dokyung.food.model.FoodSearchDTO;
import com.dokyung.food.model.FoodVO;

public interface FoodService {
	
	public List<FoodSearchDTO> SelectAll();
	public List<FoodSearchDTO> FindByName(String fd_name);
	public String FindByNameO(String fd_name);
	public int insert(FoodVO vo);
	public void delete();
	
	

}
