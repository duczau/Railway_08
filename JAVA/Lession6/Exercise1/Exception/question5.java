package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class question5 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(inputAge());

	}

	public static int inputAge() {

		System.out.println("nhapso: ");

		try {
			int a = scanner.nextInt();

			if (a < 0) {
				System.out.println("Wrong inputing! The age must be greater than 0, please input again");
			} else {
				System.out.println(a);
			}

		} catch (InputMismatchException e) {
			System.out.println("wrong inputing! Please input an age as int, input again.");
		}
		return 0;

	}
}
