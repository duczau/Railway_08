package com.vti.entity;

import java.util.Arrays;
import java.util.Date;

public class Group {
	private int id;
	private String name;
	Account creatorID;
	Account[] accounts;
	Date createDate;

	public Group() {
	}

	public Group(String GroupName, Account CreatorID, Account[] accounts, Date CreateDate) {
		this.name = GroupName;
		this.creatorID = CreatorID;
		this.createDate = CreateDate;
		this.accounts = accounts;

	}

	public Group(String name, Account creatorID, String[] usename, Date createDate) {
		this.name = name;
		this.creatorID = creatorID;
		this.createDate = createDate;
		
		Account[] accounts = new Account[usename.length];

		for (int i = 0; i < usename.length - 1; i++) {
			accounts[i] = new Account(i, usename[i], null, null, null, null);
		}

		this.createDate = createDate;
	}

	
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creatorID=" + creatorID + ", accounts="
				+ Arrays.toString(accounts) + ", createDate=" + createDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public Account getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Account creatorID) {
		this.creatorID = creatorID;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}