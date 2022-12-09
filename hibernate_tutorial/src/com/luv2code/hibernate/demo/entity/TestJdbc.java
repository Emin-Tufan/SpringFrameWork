package com.luv2code.hibernate.demo.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/hb_student_tracker?userSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connection url :  "+url);
			Connection myConn=DriverManager.getConnection(url,user,pass);
			myConn.close();
			System.out.println("Connection Sucess");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
