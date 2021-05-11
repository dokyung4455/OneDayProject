package com.dokyung.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dokyung.food.model.FoodDTO;
import com.dokyung.food.persistence.DBContract;

public class MyFoodServiceImplV1 implements MyFoodService {
	Connection dbConn;
	public MyFoodServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDBConnection();
	}

	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		List<FoodDTO> fdList = new ArrayList<FoodDTO>();
		ResultSet rStr = pStr.executeQuery();
		while (rStr.next()) {

			FoodDTO fdDTO = new FoodDTO();
			fdDTO.setDate(rStr.getString("날짜"));
			fdDTO.setFname(rStr.getString("식품명"));
			fdDTO.setQty(rStr.getInt("섭취량"));
			fdDTO.setGram(rStr.getInt("총내용량") * fdDTO.getQty());
			fdDTO.setKcal(rStr.getInt("칼로리") * fdDTO.getQty());
			fdDTO.setProt(rStr.getInt("단백질") * fdDTO.getQty());
			fdDTO.setFat(rStr.getInt("지방") * fdDTO.getQty());
			fdDTO.setCarbo(rStr.getInt("탄수화물") * fdDTO.getQty());
			fdDTO.setSacc(rStr.getInt("총당류") * fdDTO.getQty());
			fdList.add(fdDTO);

		}
		return fdList;
	}

	@Override
	public List<FoodDTO> SelectAll() {
		String sql = " SELECT * FROM view_섭취정보 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FoodDTO> FindByName(String fd_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String FindByDate(String fd_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
