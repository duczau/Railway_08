package vti.polymorphism;

public class MyMath {
	public float sum(float a, float b) {
		return a+b;
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int sum(Byte a, Byte b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		MyMath math = new MyMath();
		
		System.out.print(math.sum(20, 10));
	}
}
