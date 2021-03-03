package com.vti.entity;

public class Account_encapsulation_qs2 {
	private String id;
	private String name;
	private int balance;
	
		
	public Account_encapsulation_qs2(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	
	public int credit(int amount) {
		return amount;
	}
	
	public int debit(int amount) {
		return amount;
	}
	
	public void transferTo(Account_encapsulation_qs2 account, int amount) {
		System.out.println("transfer "+account+" to "+account.getName());
	}
}
