package com.dokyung.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	protected static Connection dbConn = null;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver"; // 접속 드라이브 설정 oracle6
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB 접속 경로
		String username = "food"; // DB 아이디
		String password = "food"; // DB 패스워드
		
		try {
			Class.forName(jdbcDriver); // 왜쓰는건지
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url,username,password); // DB접속 정보 전달
			}
			System.out.println("ORACLE CONNECT OK!");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver를 찾을 수 없습니다.");
			System.out.println("Oracle6.jar를 확인하세요.");
		} catch (SQLException e) {
			System.out.println("Oracle Connect faild..");
			System.out.println("접속정보를 확인하세요.");
			System.out.println("-".repeat(50));
			System.out.println("URL : " + url);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			System.out.println("-".repeat(50));
		}
	} // end static
	
	public static Connection getDBConnection() { // Run 하는순간 자동실행되기위함
		return dbConn;
	}

}
