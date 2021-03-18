package com.vti.Candidate.Ultils;

import java.util.Scanner;

public class ScannerUltils {
	private static Scanner scanner = new Scanner(System.in);

	// Nhap so Int > 0
	public static int inputId() {
		while (true) {
			int id = inputInt("Please input a id as int, please input again.");
			if (id > 0) {
				return id;
			}
			// else
			System.out.println("Please input a id as int which must be greater than > 0, please input again.");
		}
	}

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String input = scanner.nextLine().trim();
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	// Nhap chuoi
	public static String inputString(String errorMessage) {
		while (true) {
			String input = scanner.nextLine().trim();
			input = input.replaceAll("\\s+", " ");
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	

	// Nhập tuổi nguyên dương
	public static int inputAge() {
		while (true) {
			int age = inputInt("Wrong inputing! Please input an age as int, input again.");

			if (age <= 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again.");

			} else {
				return age;
			}
		}
	}

	// Nhập tuổi từ 18 trở lên
	public static int inputAgeGreaterThan18() {
		while (true) {
			int age = ScannerUltils.inputAge();

			if (age >= 18) {
				return age;

			} else {
				System.out.println("Wrong inputing! The age must be greater than 18, please input again.");
			}
		}
	}

	// NHập vào gmail (cần có @gmail.com)
	public static String inputEmail(String errorMessage) {
		while (true) {
			String email = ScannerUltils.inputString(errorMessage);
			if (email == null || !email.endsWith("@gmail.com")) {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại email: ");
			} else {
				return email;
			}
		}
	}

	// Nhập vào 1 số nằm trong khoảng từ a -> b
	public static int inputFunction(int a, int b, String errorMessage) {
		while (true) {
			int number = ScannerUltils.inputInt(errorMessage);
			if (number >= a && number <= b) {
				return number;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

// Nhập password từ 6 -> 12 kí tự và có ít nhất 1 chữ cái viết hoa
	public static String inputPassword(String errorMessage) {
		while (true) {
			String password = ScannerUltils.inputString(errorMessage);
			if (password.length() < 6 || password.length() > 12) {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại password: ");
				continue;
			}

			boolean hasAtLeast1Character = false;

			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại password: ");
			}
		}
	}

	// Nhập số điện thoại
	public static String inputPhoneNumber(String errorMessage) {
		while (true) {
			String number = ScannerUltils.inputString(errorMessage);
			if (number.length() > 12 || number.length() < 9) {
				System.err.println(errorMessage);
				continue;
			}

			if (number.charAt(0) != '0') {
				System.err.println(errorMessage);
				continue;
			}

			boolean isNumber = true;

			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.println(errorMessage);
				System.out.print("Mời bạn nhập lại phone number: ");
			}

		}
	}

	// Nhập số nguyên dương
	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			int id = ScannerUltils.inputInt(errorMessage);
			if (id < 0) {
				System.err.println(errorMessage);
			} else {
				return id;
			}
		}
	}

	// NHẬP VÀO TIỀN dạng float dương
	public static float inputPositiveMoney(String erroMessage2) {
		while (true) {
			float money = ScannerUltils.inputMoney(erroMessage2);
			if (money < 0) {
				System.err.print(erroMessage2);
			} else {
				return money;
			}
		}
	}

	// Nhập vào tiền dạng float (có cả âm)
	public static float inputMoney(String errorMessage) {
		while (true) {
			try {
				String inputMoney = scanner.nextLine();
				inputMoney = inputMoney.trim();
				float outputMoney = Float.parseFloat(inputMoney);
				return outputMoney;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	// NHẬP VÀO TÊN VÀ CHUẨN HÓA TÊN (chuyển chuỗi nhập có viết hoa chữ đầu mỗi
	// chữ):
	public static String inputName(String errorMessage) {
		while (true) {

			String name = ScannerUltils.inputString(errorMessage);
//			s.matches("^[a-zA-Z]*$")
			String[] words = name.split(" ");
			name = "";

			for (String word : words) {
				if (word.matches("^[a-zA-Z]*$")) {
					String firstCharacter = word.substring(0, 1).toUpperCase();
					String leftCharacter = word.substring(1).toLowerCase();
					word = firstCharacter + leftCharacter;
					name += word + " ";
				} else {
					return "Nhap ten chi co chu cai !!";
				}
			}
			return name;
		}
	}
}
