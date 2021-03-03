package qs1_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//	ex5 
//	Question 1: inheritance
//	Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
//	Mỗi cán bộ cần quản lý các dữ liệu: H�? tên, tuổi, giới tính(name, nữ,
//	khác), địa chỉ.
//	Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
//	Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
//	Các nhân viên có thuộc tính riêng: công việc.
//	Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp
//	CanBo.
//	Question 2: Tiếp tục Question 1
//	Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực
//	hiện các chức năng sau:
//	a) Thêm mới cán bộ.
//	b) Tìm kiếm theo h�? tên.
//	c) Hiện thị thông tin v�? danh sách các cán bộ.
//	d) Nhập vào tên của cán bộ và delete cán bộ đó
//	e) Thoát kh�?i chương trình.


public class QLCB {
	ArrayList<CanBo> listCanbo = new ArrayList<>();

	public void addCanbo() {
		Scanner scanner = new Scanner(System.in);
		String name;
		System.out.println("Nhap ten: ");
		name = scanner.nextLine();
		
		System.out.println("Tuoi: ");
		int tuoi = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Dia chi: ");
		String address = scanner.nextLine();
		
		System.out.println("Gioi tinh: ");
		String gender  = scanner.nextLine();
		
		CanBo canBo = new CanBo(name,tuoi,gender,address);
		listCanbo.add(canBo);
	}
	
	public void showlist() {
		for (CanBo canBo : listCanbo) {
			System.out.println(canBo.toString());
		}
	}

	public void deleteCanbo(String name) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("nhap ten can xoa: ");
//		name = scanner.nextLine();

		for (int i = 0; i < listCanbo.size(); i++) {
			if (listCanbo.get(i).getName().equals(name)) {
				listCanbo.remove(i);
				System.out.println("da xoa");
			}
		}
	}
}
