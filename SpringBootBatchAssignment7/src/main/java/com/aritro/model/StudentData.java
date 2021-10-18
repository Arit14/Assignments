package com.aritro.model;

public class StudentData {
	
	private int studentId;
	private String username;
	private String studentFirstName;
	private String studentLastName;
	
	
	
//	public StudentData() {
		
//	}



	public StudentData(int studentId, String username, String studentFirstName, String studentLastName) {
		super();
		this.studentId = studentId;
		this.username = username;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getStudentFirstName() {
		return studentFirstName;
	}



	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}



	public String getStudentLastName() {
		return studentLastName;
	}



	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}



	public static String[] getFields() {
		// TODO Auto-generated method stub
		return new String[] {"studentId","username","studentFirstName","studentLastName"};
	}
	
	
	

}
