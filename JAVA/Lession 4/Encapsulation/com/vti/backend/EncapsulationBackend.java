package com.vti.backend;

import com.vti.entity.Circle;
import com.vti.entity.Student;

public class EncapsulationBackend {
	
	// Question 1:
		// Tạo Object Student có các property id, name, hometown, điểm học lực
		// a) Tất cả các property sẽ để là private để các class khác không chỉnh sửa hay
		// nhìn thấy
		// b) Tạo constructor cho phép khi khởi tạo mỗi student thì người dùng sẽ nhập
		// vào tên, hometown và có điểm học lực = 0
		// c) Tạo 1 method cho phép set điểm vào
		// d) Tạo 1 method cho phép cộng thêm điểm
		// e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên, điểm học lực
		// ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm > 4.0 và < 6.0 thì sẽ in ra là
		// trung bình, nếu điểm > 6.0 và < 8.0 thì sẽ in ra là khá, nếu > 8.0 thì in ra
		// là Giỏi)
		// Demo các chức năng trên bằng class ở front-end.
	
	public void qs1() {
		Student student1 = new Student("A", "viet nam");
		student1.setPoint(9);
		
		Student student2 = new Student("B", "Lao");
		student2.setPoint(1);
		
		Student student3 = new Student("C", "TQ");
		student3.setPoint(2);
		student3.addPoint(5);
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}
	
//		Question 2 (Optional):
//			Tạo class phù hợp cho thiết kế
	
	public void qs2() {
		Circle circle = new Circle();
		circle.setRadius(1.0);
		circle.setColor("red");
		
		System.out.println(circle);
	}
}
