package com.vti.entity;
import java.util.Date;

public class Question {
	int id;
	String content;
	int categoryID;
	int typeID;
	int creatorID;
	Date createDate;
	
	Exam[] exam;
}
