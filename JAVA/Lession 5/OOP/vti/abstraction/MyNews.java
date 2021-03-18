package vti.abstraction;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
	static ArrayList<News> Menu = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int menu;
		do {
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");

			menu = scanner.nextInt();

			News input = new News();
			if (menu == 1) {
				System.out.println("nhap Title:");
				input.setTitle(scanner.nextLine());
				scanner.nextLine();

				System.out.println("nhap PublishDate:");
				input.setPublishDate(scanner.nextLine());

				System.out.println("nhap Author:");
				input.setAuthor(scanner.nextLine());

				System.out.println("nhap Content:");
				input.setContent(scanner.nextLine());

				System.out.println("nhap 3 Danh gia:");

				int[] rate = new int[3];
				for (int i = 0; i < 3; i++) {
					rate[i] = (scanner.nextInt());
				}
				input.setRate(rate);
				Menu.add(input);
			} else if (menu == 2) {
				for (News news : Menu) {
					news.Display();
					;
				}
			} else if (menu == 3) {
				for (News news : Menu) {
					news.Calculate();
					System.out.println(news.getTitle() + ": " + news.getAverageRate());
				}
			}

		} while (menu < 4);
		scanner.close();
	}
}
