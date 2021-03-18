package com.vti.Candidate.frontend;

import com.vti.Candidate.Ultils.ScannerUltils;

public class program {
	static function function = new function();

	public static void main(String[] args) throws Exception {
		program program = new program();
		program.signUp();
	}

	public static void menu() {
		System.out.println("--- Chọn chức năng ---");
		System.out.println("1. Tạo tài khoản");
		System.out.println("2. Đăng nhập");
		System.out.println("Nhấn 0 để thoát");
	}

	public static void loginMenu() {
		System.out.println("--- Chọn chức năng ---");
		System.out.println("1. In thông tin tất cả User");
		System.out.println("Nhấn 0 để quay lại");
		System.out.println("=============================");
	}

	public void signUp() throws Exception {

		while (true) {
			menu();

			int chose = ScannerUltils.inputFunction(0, 2, "Hay nhap so theo chi muc !!");
			switch (chose) {
			case 1:
				function.createCandidate();
				break;
			case 2:
				if (function.login()) {
					success();
				} else {
					System.err.println("tài khoản không tồn tại !");
				}
				break;
			case 0:
				System.out.println("tam biet !!");
				return;
			default:
				break;
			}

		}
	}

	public void success() throws Exception {
		while (true) {
			loginMenu();

			int chose = ScannerUltils.inputFunction(0, 1, "Hay nhap so theo chi muc !!");
			switch (chose) {
			case 1:
				function.getListCandidate();
				break;
			case 0:
				signUp();
				return;
			default:
				break;
			}

		}
	}
}
