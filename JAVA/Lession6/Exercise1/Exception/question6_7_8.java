package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class question6_7_8 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//		System.out.println(inputPositiveInt("Wrong inputing! The age must be greater than 0, please input again"));
		System.out.println(inputString());
	}

// question 6 + 7

	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			System.out.println("nhapso: ");

			try {
				int a = scanner.nextInt();

				if (a < 0) {
					System.out.println(errorMessage);
					continue;
				} else {
					return a;
				}
			} catch (InputMismatchException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
			}
		}
	}

	public static float inputFloat(String errorFloat) {
		while (true) {
			System.out.println("nhapso: ");

			try {
				float a = scanner.nextInt();

				if (a < 0) {
					System.out.println(errorFloat);
					continue;
				} else {
					System.out.println(a);
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
				scanner.nextLine();
				continue;
			}
		}
		return 0;
	}

	public static double inputDouble(String errorDouble) {
		while (true) {
			System.out.println("nhapso: ");

			try {
				double a = scanner.nextFloat();

				if (a < 0) {
					System.out.println(errorDouble);
					continue;
				} else {
					System.out.println(a);
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
				scanner.nextLine();
				continue;
			}
		}
		return 0;
	}

	public static String inputString() {
			System.out.println("nhap chu: ");
			
			String a = scanner.next();
			return a;
	}

}
