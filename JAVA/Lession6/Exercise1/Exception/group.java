package Exception;

import java.time.LocalDate;
import java.util.Arrays;


public class group {

	private int id;
	private String name;
	private account[] accounts;
	private LocalDate createDate;

	public group() {
		accounts = new account[1000];
		input();
	}

	private void input() {
		System.out.println("Nhập id : ");
		id = question6_7_8.inputPositiveInt("hay nhap so nguyen duong");

		System.out.println("Nhập tên : ");
		name = question6_7_8.inputString();

		confirmAddAccount();
	}

	private void confirmAddAccount() {
		System.out.println("Bạn có muốn add account không? (nhập 1 là có, 2 là không): ");

		int choose;
		while (true) {
			choose = question6_7_8.inputPositiveInt("nhap so nguyen duong");

			switch (choose) {
			case 1:
				return;

			case 2:
				addAccount();
				return;

			default:
				System.out.println("Chỉ được nhập 1 hoặc 2: ");
				break;
			}
		}
	}

	private void addAccount() {
		System.out.println("Nhập số lượng account có trong group: ");
		int n = question6_7_8.inputPositiveInt("Please input a number as int, please input again.");

		for (int i = 0; i < n; i++) {
			accounts[i] = new account();
		}
	}

	@Override
	public String toString() {
		return "Group{" + "id=" + id + ", name='" + name + '\'' + ", accounts=" + Arrays.toString(accounts)
				+ ", createDate=" + createDate + '}';
	}
}
