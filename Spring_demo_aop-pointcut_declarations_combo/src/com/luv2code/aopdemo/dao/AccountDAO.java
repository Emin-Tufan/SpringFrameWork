package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(this.getClass()+" : Doing My Db Work : Adding an Account ");
	}
}
