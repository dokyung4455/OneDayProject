package com.dokyung.food.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dokyung.food.model.FoodVO;
import com.dokyung.food.service.FoodService;
import com.dokyung.food.service.FoodServiceImplV1;

@WebServlet("/page2")
public class InsertController extends HttpServlet {
	FoodService fService;

	public InsertController() {
		// TODO Auto-generated constructor stub
		fService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String food = req.getParameter("id");
		new FoodServiceImplV1();
		String code = fService.FindByNameO(food);

		req.setAttribute("FOOD", food);
		req.setAttribute("CODE", code);
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String food = req.getParameter("FOOD");
		String code = req.getParameter("CODE");
		String date = req.getParameter("date");
		Integer qty = Integer.valueOf(req.getParameter("qty"));

		System.out.println("섭취날짜 : " + date);
		System.out.println("식품코드 : " + code);
		System.out.println("섭취음식 : " + food);
		System.out.println("섭 취 량 : " + qty);

		FoodVO fVO = new FoodVO();
		fVO.setDate(date);
		fVO.setIcode(code);
		fVO.setQty(qty);
		int result = fService.insert(fVO);
		System.out.println("저장완료");
		if(result > 0) {
		resp.sendRedirect("/food");
		}
	}

}
