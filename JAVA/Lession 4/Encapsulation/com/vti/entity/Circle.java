package com.vti.entity;

public class Circle {
	double radius;
	String color;
	double PI = 3.14f;
	
	public Circle() {
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return PI * Math.pow(radius, 2);
	}
	
	@Override
	public String toString() {
		return "Circle: radius= "+radius+", color= "+color;
	}
}
