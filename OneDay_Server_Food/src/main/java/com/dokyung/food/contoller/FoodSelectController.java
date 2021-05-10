package com.dokyung.food.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dokyung.food.model.FoodSearchDTO;

@WebServlet("/select")
public class FoodSelectController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		FoodSearchDTO fsD = new FoodSearchDTO();
		fsD.getCarbo();
		fsD.getCp_name();
		fsD.getCp_code()
		fsD.getc
		
		
		
		
		
		
		
		
		
		
		
		req.getRequestDispatcher("WEB-INF/views/page1.jsp").forward(req, resp);
		
	}
	
	

}
