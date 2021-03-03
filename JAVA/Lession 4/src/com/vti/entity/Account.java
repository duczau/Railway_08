package com.vti.entity;
import java.time.LocalDate;
import java.util.Date;

public class Account {
	public int id;
	private String email;
	private String userName;
	String fullName;
	String firstName;
	String lastName;
	Department department;
	Position position;
	LocalDate createDate;
	
	Group[] group;
	
	
	public Account() {
		createDate = LocalDate.now();
	}
	
	
	public Account(int id, String email, String userName, String fullName, String firstName, String lastname) {
		this.id=id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		fullName = firstName + lastname;
	}
	
	public Account(int id, Position position, String email, String userName, String fullName, String firstName, String lastname) {
		this.createDate = LocalDate.now();
		this.id=id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		fullName = firstName + lastname;
		this.position = position;
	}
	
	public Account(int id, Position position, String email, String userName, String fullName, String firstName, String lastname, LocalDate createDate) {
		this.createDate = createDate;
		this.id=id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		fullName = firstName + lastname;
		this.position = position;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public void setUsername(String usename) {
		this.userName = usename;
	}
}
