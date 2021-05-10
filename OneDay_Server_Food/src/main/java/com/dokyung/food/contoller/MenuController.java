package com.dokyung.food.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// WebBrowser의 req에 반응한 클래스 이름이 무엇이냐
		String servletName = this.getServletName();
		System.out.println("Servlet name : " + servletName);
		
		// 현재 Project의 Context가 무엇인가
		String rootPath = req.getContextPath();
		System.out.println("Root Path : " + rootPath);
		
		// 요청 path에 부착된 질의데이터 보기
		String queryString = req.getQueryString();
		System.out.println("query String : " + queryString);
		
		String strId = req.getParameter("id");
		System.out.println("ID값 : " + strId); // /hello/menu/ 뒤에 붙는 값,ID
		
		PrintWriter out = resp.getWriter();
		
		if(strId.equals("input")) {
			resp.sendRedirect("/food/input");
		}
	}
	
	

}
