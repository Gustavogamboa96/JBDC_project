package com.conigxia.jump.dao;

public class Employee {
	private int employee_id;
	private String fname, lname, email;
	
	public Employee() {
		
	}
	
	public Employee(int employee_id, String fname, String lname, String email) {
		super();
		this.employee_id = employee_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		
	}
	public Employee(String fname, String lname, String email) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		
	}
	public String getFname() {
		return this.fname;
	}
	public String getLname() {
		return this.lname;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void printEmployee() {
		System.out.println("Name: "+fname +" "+ lname+ "\n"+
				"Email: "+email+"\n"+
				"Employee ID: "+ employee_id+"\n");
	}

}
