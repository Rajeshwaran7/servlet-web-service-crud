package com.ty.studentapp.dao;

public class Student {
	private int sId;
	private String name;
	private double marks;
	private String emailId;
	private String pwd;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Student() {
		
	}
	
	public Student(int sId, String name, double marks, String emailId, String pwd) {
		super();
		this.sId = sId;
		this.name = name;
		this.marks = marks;
		this.emailId = emailId;
		this.pwd = pwd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
