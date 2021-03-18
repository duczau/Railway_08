package frontend;

import java.util.ArrayList;

import entity.Car;
import entity.Motobike;
import entity.Vehicle;

public class main {

	public static void main(String[] args) {

//		Car car1 = new Car();
//		car1.di();
//		
//		Motobike moto1 = new Motobike();
//		moto1.di();
		
		Vehicle vehicle1 = new Car();
		vehicle1.di();
		
		Vehicle vehicle2 = new Motobike();
		vehicle2.di();
		
		ArrayList<String> listVehicle = new ArrayList<String>();
		
		listVehicle.add("a");
		listVehicle.add("b");
	}
	
}
