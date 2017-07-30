package com.spring.struts2.beans;

public class Person {
	private String username;

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void test(){
		System.out.println("My name is "+username);
	}
}
