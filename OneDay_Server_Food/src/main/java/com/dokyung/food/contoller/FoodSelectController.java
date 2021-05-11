package com.dokyung.food.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dokyung.food.model.FoodSearchDTO;
import com.dokyung.food.model.FoodVO;
import com.dokyung.food.service.FoodService;
import com.dokyung.food.service.FoodServiceImplV1;

@WebServlet("/select")
public class FoodSelectController extends HttpServlet {
	protected FoodService fService;

	public FoodSelectController() {
		// TODO Auto-generated constructor stub
		fService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String search = req.getParameter("fd_food");
		System.out.println(search);
		if (search.equals("")) {
			List<FoodSearchDTO> fList = new ArrayList<FoodSearchDTO>();
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();

			fList = fService.SelectAll();
			req.setAttribute("FOOD", fList);
		} else {
			List<FoodSearchDTO> fList = new ArrayList<FoodSearchDTO>();
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();

			fList = fService.FindByName(search);
			req.setAttribute("FOOD", fList); // fList 리스트변수를 jsp에서 FOOD로 쓸거임
		}

		req.getRequestDispatcher("WEB-INF/views/page1.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	

	}

}
