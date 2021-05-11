package com.dokyung.food.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dokyung.food.model.FoodDTO;
import com.dokyung.food.service.MyFoodService;
import com.dokyung.food.service.MyFoodServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{
	
	MyFoodService mService = new MyFoodServiceImplV1();
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<FoodDTO> fDTO = new ArrayList<FoodDTO>();
		fDTO = mService.SelectAll();
		req.setAttribute("FOOD", fDTO);
		req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
		
		
		
		
	}
	
	

}
