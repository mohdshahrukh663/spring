package com.cognizant.server.model;

import java.util.Date;

public class Person {
	
	private long aadharNo;
	private String name;
	private String gender;
	private Date dob;
	static long counter=100000000000L;
	public Person(String name, String gender, Date dob) {
		super();
		aadharNo=++counter;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public static long getCounter() {
		return counter;
	}
	
	

}
