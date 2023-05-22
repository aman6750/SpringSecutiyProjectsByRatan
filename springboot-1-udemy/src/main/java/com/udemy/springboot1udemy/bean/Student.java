package com.udemy.springboot1udemy.bean;


public class Student {
	
	private Integer stuid;
	private String firstname;
	private String lastname;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer stuid, String firstname, String lastname) {
		super();
		this.stuid = stuid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Integer getStuid() {
		return stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
	

}
