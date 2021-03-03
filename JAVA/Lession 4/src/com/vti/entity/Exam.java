package com.vti.entity;
import java.util.Date;

public class Exam {
	int id;
	String code;
	String title;
	CategoryQuestion category;
	int duration;
	Account	creator;
	Date creatDate;
	
	Question[] question;
}
