package com.vti.Candidate.backend.entity;

public class Candidates {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private String type;

	public Candidates(int id, String firstName, String lastName, String phone, String email, String password,
			String type) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return "0"+phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\n Candidate id= " + id + ", firstName= " + firstName + ", lastName= " + lastName + ", phone= " + phone
				+ ", email= " + email + ", type= " + type;
	}

}
