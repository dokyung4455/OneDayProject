package com.dokyung.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dokyung.food.model.FoodDTO;
import com.dokyung.food.model.FoodSearchDTO;
import com.dokyung.food.persistence.DBContract;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	public FoodServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDBConnection();
	}
	protected List<FoodSearchDTO> select(PreparedStatement pStr) throws SQLException {
		List<FoodSearchDTO> fdList 
			= new ArrayList<FoodSearchDTO>();;
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			FoodSearchDTO fdDTO = new FoodSearchDTO();
			fdDTO.setFd_code(rStr.getString("식품코드"));
			fdDTO.setFd_name(rStr.getString("식품명"));
			fdDTO.setFd_date(rStr.getString("출시연도"));
			fdDTO.setCp_name(rStr.getString("제조사명"));
			fdDTO.setIt_code(rStr.getString("분류명"));
			fdDTO.setFd_one(rStr.getInt("1회 제공량"));
			fdDTO.setFd_gram(rStr.getInt("총 제공량"));
			fdDTO.setFd_kcal(rStr.getInt("총 칼로리"));
			fdDTO.setFd_prot(rStr.getInt("단백질 섭취량"));
			fdDTO.setFd_fat(rStr.getInt("지방 섭취량"));
			fdDTO.setCarbo(rStr.getInt("탄수화물 섭취량"));
			fdDTO.setSacc(rStr.getInt("당 섭취량"));
			fdList.add(fdDTO);
		
		
		}
		return fdList;
	}
	
	@Override
	public List<FoodSearchDTO> SelectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodSearchDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void FindByName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
