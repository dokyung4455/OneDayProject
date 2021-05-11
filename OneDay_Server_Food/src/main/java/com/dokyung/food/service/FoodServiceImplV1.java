package com.dokyung.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dokyung.food.model.FoodDTO;
import com.dokyung.food.model.FoodSearchDTO;
import com.dokyung.food.model.FoodVO;
import com.dokyung.food.persistence.DBContract;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	public FoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	protected List<FoodSearchDTO> select(PreparedStatement pStr) throws SQLException {
		List<FoodSearchDTO> fdList 	= new ArrayList<FoodSearchDTO>();
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			FoodSearchDTO fdDTO = new FoodSearchDTO();
			fdDTO.setFd_code(rStr.getString("식품코드"));
			fdDTO.setFd_name(rStr.getString("식품명"));
			fdDTO.setFd_date(rStr.getString("출시연도"));
			fdDTO.setCp_name(rStr.getString("제조사명"));
			fdDTO.setIt_code(rStr.getString("분류명"));
			fdDTO.setFd_one(rStr.getInt("회제공량"));
			fdDTO.setFd_gram(rStr.getInt("총내용량"));
			fdDTO.setFd_kcal(rStr.getInt("칼로리"));
			fdDTO.setFd_prot(rStr.getInt("단백질"));
			fdDTO.setFd_fat(rStr.getInt("지방"));
			fdDTO.setCarbo(rStr.getInt("탄수화물"));
			fdDTO.setSacc(rStr.getInt("총당류"));
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
	public List<FoodSearchDTO> FindByName(String fd_name) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명"; 
		sql += " LIKE '%' || ? || '%' ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_name.trim());
			List<FoodSearchDTO> fList = this.select(pStr);
			pStr.close();
			return fList;
		} catch (SQLException e) {
			System.out.println("findByFname 오라클 연동 오류");
		}
		return null;

	}

	@Override
	public int insert(FoodVO vo) {
		String date = vo.getDate();
		String code = vo.getIcode();
		Integer qty = vo.getQty();
		
		String sql = " INSERT INTO tbl_myfoods ";
		sql += "(mf_seq, mf_date, mf_icode, mf_qty) ";
		sql += " VALUES(seq_myfoods.NEXTVAL, ?, ?, ?) ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			pStr.setString(2, code);
			pStr.setInt(3, qty);
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
return 0;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
	@Override
	public String FindByNameO(String fd_name) {
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명"; 
		sql += " LIKE '%' || ? || '%' ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_name.trim());
			List<FoodSearchDTO> fList = this.select(pStr);
			String code = fList.get(0).getFd_code();
			
			pStr.close();
			return code;
		} catch (SQLException e) {
			System.out.println("findByFname 오라클 연동 오류");
		}
		
		
		return null;
	}

}
