package qs2_3;

public abstract class User {
	String name;
	double salary;
	
	public User(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public abstract double calculatePay();
	
	public void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Pay: " + calculatePay());
	}
}
