package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		final String user="springstudent";
		final String pass="springstudent";
		final String driver="com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			PrintWriter print=response.getWriter();
			print.println("Islem Basliyor");
			Connection conn=DriverManager.getConnection(url,user,pass);
			print.print("Islem Basarili");
			conn.close();
			
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
	}

}
