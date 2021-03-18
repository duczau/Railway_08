package vti.polymorphism;

import java.util.ArrayList;
import java.util.Random;

public class main {
	private static Random random = new Random();
	private static ArrayList<Student> listStudent = new ArrayList<Student>();

	public static void main(String[] args) {
		addHS();
		goidiemdanh();
		goiHocBai();
		HinhChuNhat hinhChuNhat = new HinhChuNhat();
		hinhChuNhat.Chuvi();
		hinhChuNhat.Dientich();
		HinhVuong hinhVuong = new HinhVuong();
		hinhVuong.Chuvi();
		hinhVuong.Dientich();
	}

	public static void addHS() {
		for (int i = 0; i < 10; i++) {
			String name = "a" + i;
			int group = random.nextInt(2);
			listStudent.add(new Student(i, name, group));
		}
	}

	public static void goidiemdanh() {
		for (Student student : listStudent) {
			student.diemdanh();
		}
	}

	public static void goiHocBai() {
		for (Student student : listStudent) {
			if (student.getGroup() == 0) {
				student.hocbai();
			} else if (student.getGroup() == 1) {
				student.dondep();
			} else {
				System.out.println("loi");
			}
		}
	}
}
