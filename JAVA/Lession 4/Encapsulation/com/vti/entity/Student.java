package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float point;
	

	public Student(String name, String home) {
		this.point = 0f;
		this.name = name;
		this.hometown = home;
	}
	
	public void setPoint(float point) {
		this.point = point;
	}
	
	public void addPoint(float addPoint) {
		this.point += addPoint;
	}
	
	@Override
	public String toString() {
		String info;
		if (point < 4.0) {
			info = "yếu";
		} else if (point >= 4.0 && point < 6.0) {
			info = "tb";
		} else if (point >= 6.0 && point < 8.0) {
			info = "khá";
		} else {
			info = "very good";
		}
		
		return "Student: id= " + id + ", name= "+ name+", home= "
				+ hometown + ", diem= "+ point+ " -> Xep loai: "+ info;
	}
}
