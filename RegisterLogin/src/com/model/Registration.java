package com.model;

public class Registration {

	private String name;
	private String email;
	private String city;
	private String pass;
	
	public Registration() {
		super();
	}

	public Registration(String name, String email, String city, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String pass) {
		this.city = city;
	}
	public String getPass() {
		return pass;
	}

	public void setCity(String pass) {
		this.pass = pass;
	}
	
}
