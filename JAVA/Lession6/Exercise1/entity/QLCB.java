package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {

	private List<CanBo> canBos;
	private Scanner scanner;

	public QLCB() {
		canBos = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public QLCB(List<CanBo> canBos) {
		this.canBos = canBos;
	}

	public void addCanBo() {
		System.out.print("Báº¡n muá»‘n add bao nhiÃªu cÃ¡n bá»™: ");
		int x = scanner.nextInt();
		for (int i = 0; i < x; i++) {
			System.out.print("Báº¡n muá»‘n nháº­p vÃ o nhÃ¢n viÃªn(nháº­p vÃ o 1), CÃ´ng nhÃ¢n (nháº­p vÃ o 2), ká»¹ sÆ° (nháº­p vÃ o 3): ");
			int choose = scanner.nextInt();
			CanBo canBo = null;													// ==> tạo biến để lưu thông tin
			switch (choose) {
			case 1:
				canBo = new NhanVien(null, choose, null, null, null);			// ==> không có lệnh để lưu thông tin cán bộ mới nhập
				break;															// ==> sử dụng biến đã tạo để lấy thông tin đã nhập
			case 2:
				canBo = new CongNhan();
				break;
			case 3:
				canBo = new KySu(null, choose, null, null, null);
				break;
			}
			canBos.add(canBo);													// ==> thêm vào list canBos
			System.out.println("Nháº­p thÃ nh CÃ¡n bá»™ " + (i + 1));
		}
	}

	public void findByName() {
		// TODO
		System.out.println("findByName");
	}

	public void printListCanBo() {
		for (int i = 0; i < canBos.size(); i++) {													
			System.out.println("ThÃ´ng tin cÃ¡n bá»™ " + (i + 1) + " lÃ : " + canBos.get(i)); 		// ==> hiển thị cán bộ = thêm canBos.get(i)
		}
		System.out.println("----------------------------");
	}

	public void deleteCanBo(String name) {
		// TODO
		System.out.println("deleteCanBo");
	}

	public void deleteCanBo() {

		String inputName = scanner.nextLine();
		deleteCanBo(inputName);
	}
}
