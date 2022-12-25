package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private String name;
	private String level;
	
	public Account() {
		this.name="Emin";
	}
	
	public void selam(){
		
		System.out.println("Hello World !");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
}
