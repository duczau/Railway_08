package com.vti.Candidate.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Candidate.Ultils.ScannerUltils;
import com.vti.Candidate.backend.controller.CandidateController;
import com.vti.Candidate.backend.entity.Candidates;

public class function {
	public CandidateController candidateController = new CandidateController();

	public void getListCandidate() throws Exception {
		List<Candidates> candidates = candidateController.getListCandidatesController();
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "phone", "Type");
		for (Candidates candidate : candidates) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", candidate.getId(), candidate.getEmail(),
					candidate.getPhone(), candidate.getType());
		}

	}


	public boolean login() throws Exception {
		while (true) {
			System.out.print("Nhập vào Email: ");
			String email = ScannerUltils.inputEmail("Email chưa đúng định dạng.");

			System.out.print("Password: ");
			String password = ScannerUltils
					.inputPassword("Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!");
			try {
				return candidateController.loginController(email, password);
			} catch (Exception e) {
				System.err.println("lỗi khi đăng nhập !");
			}
		}
	}

	public void createCandidate() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		try {
			
		System.out.println("Nhập email mới: ");
		String newEmail = ScannerUltils.inputEmail("Nhap dung dinh dang email(....@gmail.com)");
		
		System.out.println("Nhập password: ");
		String password = ScannerUltils.inputPassword("pass từ 6 - 12 kí tự, có ít nhất 1 chữ viết hoa !!");
		
		System.out.println("Nhập phone mới: ");
		String newPhone = ScannerUltils.inputPhoneNumber("sdt từ 9 tới 12 số ,bắt đầu từ 0 !!");
		
		System.out.println("Nhập exp year: ");
		int expInYear =ScannerUltils.inputFunction(0, 10, " nhập số nguyên từ 0 tới 10 !!");
		
		System.out.println("Nhập graduationRank (good,excellent,fair,poor): ");
		String graduationRank = ScannerUltils.inputString("Nhập đúng định dạng !!").toLowerCase();
		
		if (!candidateController.isCandidateEmailExistsController(newEmail)) {
			candidateController.createCandidateController(newPhone, newEmail,password, expInYear, graduationRank);
			System.out.println("Da tao thanh cong tai khoan email la : " + newEmail);
		}
		} catch (Exception e) {
			System.err.println("Chưa nhập đúng rank hoặc email đã tồn tại !!");
		}

	}

}
