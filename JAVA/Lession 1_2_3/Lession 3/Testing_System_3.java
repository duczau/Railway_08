import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Testing_System_3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// create department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "CEO";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Marketing";

		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Boss of director";

		Department department5 = new Department();
		department5.id = 5;
		department5.name = "waiting room";

		// create Position
		Position position1 = new Position();

		Position position2 = new Position();
		position2.id = 2;
		position2.name = "Position 2";

		Position position3 = new Position();
		position3.id = 3;
		position3.name = "Position 3";

		// create account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "abc@gmail.com";
		account1.userName = "abc";
		account1.fullName = "A B C";
		account1.department = department5;
		account1.position = position1;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "def@gmail.com";
		account2.userName = "def";
		account2.fullName = "D E F";
		account2.department = department5;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "gh@gmail.com";
		account3.userName = "gh";
		account3.fullName = "G H";
		account3.department = department5;

		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Nhom 1";

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Nhom 2";

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Nhom 3";

		// create answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Tra loi";
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "khong Tra loi";
		answer2.isCorrect = false;

		Answer answer3 = new Answer();
		answer3.id = 3;
		answer3.content = "Tra loi dung";
		answer3.isCorrect = true;

		// create categoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.id = 1;
		categoryQuestion1.name = "essay";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.id = 2;
		categoryQuestion2.name = "multi";

		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.id = 3;
		categoryQuestion3.name = "multi";

		// create exam
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "a1";
		exam1.title = "title 1";
		exam1.creatDate = new Date("2020/12/10");

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "a2";
		exam2.title = "title 2";
		exam2.creatDate = new Date("2010/03/01");

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "a3";
		exam3.title = "title 3";
		exam3.creatDate = new Date("2008/06/03");

		// create question
		Question question1 = new Question();
		question1.id = 1;
		question1.content = "Question 1";
		question1.createDate = new Date();

		Question question2 = new Question();
		question2.id = 2;
		question2.content = "Question 2";
		question2.createDate = new Date("2021/01/02");

		Question question3 = new Question();
		question3.id = 3;
		question3.content = "Question 3";
		question3.createDate = new Date("2021/12/10");

//		 accounts
		Account[] accounts = { account1, account3 };
		Group[] groups = { group1, group2, group3 };
		group3.account = accounts;
		group2.account = accounts;
		account1.department = department1;
		account2.group = groups;

		Account[] listAccounts = { account1, account2, account3 };
		Department[] listDepartments = { department1, department2, department3, department4, department5 };
		Group[] listGroups = { group1, group2, group3 };

//		Ex1 Datatype Casting
//			qs1
//				float luong1 = 5240.9f;
//				float luong2 = 10970.055f;
//				
//				int lamtron1 = (int) luong1;
//				int lamtron2 = (int) luong2;
//				
//				System.out.println(lamtron1 + "\n" + lamtron2);

//			qs 2 + 3 

//				int min = 0;
//				int max = 99999;
//				int a = (int) (Math.random() * max) + min;
//				String finalString = String.format("%05d", a);
//				
//				System.out.printf("=Question2=\n");
//				System.out.println("Số ngẫu nhiên: " + finalString);
//		
//				System.out.println("=Question3=");
//				String b = String.valueOf(finalString);
//				System.out.println("Hai số cuối: " + b.substring(3));

//			qs 4
//				int a, b;
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("a = ");
//				a = scanner.nextInt();
//				do {
//					System.out.println("b = ");
//					b = scanner.nextInt();
//					if (b == 0) {
//						System.out.println("Vui lòng nhập b khác 0 !");
//					}
//				} while (b == 0);
//		
//				scanner.close();
//		
//				System.out.println("Thương: " + (float) a / (float) b);

//		Ex2 Default value

//			accNew();

//		Ex3 
//			qs 1
//				Integer salary = 5000;
//				System.out.printf("%2.2f", (float) salary);

//			qs 2
//				String s1 = "1234567";
//				Integer a = Integer.parseInt(s1);
//				System.out.println(a);

//			qs3
//				Integer a = 1234567;
//				int b = a.intValue();
//				System.out.println(b);

//		Ex4 String
//			Qs1
//				String s1;
//				Scanner scanner = new Scanner(System.in);
//		
//				System.out.println("Nhập chuỗi: ");
//				s1 = scanner.nextLine();
//		
//				String[] words = s1.split(" ");
//				System.out.println("Số kí tự: " + words.length);

//			qs2

//				Scanner scanner = new Scanner(System.in);
//
//				System.out.println("Nhập chuỗi 1: ");
//				String s1 = scanner.nextLine();
//
//				System.out.println("Nhập chuỗi 2: ");
//				String s2 = scanner.nextLine();
//
//				System.out.println("Sau khi nối chuỗi : " + s1.concat(s2));

//			qs3

//				Scanner scanner = new Scanner(System.in);
//				String name;
//		
//				System.out.println("Nhập Tên: ");
//				name = scanner.nextLine();
//		
//				String firstCharacter = name.substring(0, 1).toUpperCase();
//		
//				String leftCharacter = name.substring(1);
//		
//				name = firstCharacter + leftCharacter;
//		
//				System.out.println(name);

//			qs4

//				String name;
//				Scanner scanner = new Scanner(System.in);
//		
//				System.out.println("Nhập tên: ");
//				name = scanner.nextLine();
//		
//				name = name.toUpperCase();
//		
//				for (int i = 0; i < name.length(); i++) {
//					System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
//				}

//			qs5

//				Scanner scanner = new Scanner(System.in);
//		
//				System.out.println("Nhập họ: ");
//				String firstName = scanner.nextLine();
//		
//				System.out.println("Nhập tên: ");
//				String lastName = scanner.nextLine();
//		
//				System.out.println("Họ tên đầy đủ: " + firstName.concat(lastName));

//			qs6

//				String fullName;
//				String lastName = "", middleName = "", firstName = "";
//		
//				Scanner scanner = new Scanner(System.in);
//		
//				System.out.println("Nhập họ tên đầy đủ:");
//				fullName = scanner.nextLine();
//				fullName = fullName.trim();
//				String[] words = fullName.split(" ");
//		
//				lastName = words[0];
//				firstName = words[words.length - 1];
//		
//				for (int i = 1; i <= words.length - 2; i++) {
//					middleName += words[i] + " ";
//				}
//		
//				System.out.println("Họ là: " + lastName);
//				System.out.println("Tên đệm là: " + middleName);
//				System.out.println("Tên là: " + firstName);

//			qs7

//				Scanner scanner = new Scanner(System.in);
//				String fullName;
//		
//				System.out.println("Nhập họ tên đầy đủ");
//				fullName = scanner.nextLine();
//		
//				// remove space
//				fullName = fullName.replaceAll("\\s+", " ");
//				fullName = fullName.trim();
//		
//				String[] words = fullName.split(" ");
//				fullName = "";
//		
//				for (String word : words) {
//					String firstCharacter = word.substring(0, 1).toUpperCase();
//					String leftCharacter = word.substring(1);
//					word = firstCharacter + leftCharacter;
//		
//					fullName += word + " ";
//				}
//				fullName = fullName.trim();
//				System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);

//			qs8

//				String[] groupNames = { "Java with Duy Nguyễn", "Cách qua môn gia va", "Học Java có khó không?" };
//		
//				for (String groupName : groupNames) {
//					if (groupName.contains("Java")) {
//						System.out.println(groupName);
//					}
//				}

//			qs9

//				String[] groupNames = { "Java", "C#", "C++" };
//		
//				for (String groupName : groupNames) {
//					if (groupName.equals("Java")) {
//						System.out.println(groupName);
//					}
//				}

//			qs10

//				Scanner scanner = new Scanner(System.in);
//				String s1, s2, reverseS1 = "";
//		
//				System.out.println("Nhập chuỗi 1");
//				s1 = scanner.nextLine();
//		
//				System.out.println("Nhập chuỗi 2");
//				s2 = scanner.nextLine();
//				
//				for (int i = s1.length() - 1; i >= 0; i--) {
//					reverseS1 += s1.substring(i, i + 1);
//				}
//				
//				if (s2.equals(reverseS1)) {
//					System.out.println("Đây là chuỗi đảo ngược !");
//				}else {
//					System.out.println("chuoi 2 ko phai dao nguoc, dung phai la: " + reverseS1);
//				}

//			qs11

//				Scanner scanner = new Scanner(System.in);
//				String str;
//		
//				System.out.println("Mời bạn nhập vào một chuỗi: ");
//				str = scanner.nextLine();
//		
//				int count = 0;
//				for (int i = 0; i < str.length(); i++) {
//					if ('a' == str.charAt(i)) {
//						count++;
//					}
//				}
//		
//				System.out.println(count);

//			qs12

//				Scanner scanner = new Scanner(System.in);
//				String s1, reverseS1 = "";
//		
//				System.out.println("Nhập chuỗi 1");
//				s1 = scanner.nextLine();
//		
//				for (int i = s1.length() - 1; i >= 0; i--) {
//					reverseS1 += s1.charAt(i);
//				}
//		
//				System.out.println(reverseS1);

//			qs13

//				Scanner scanner = new Scanner(System.in);
//				String str;
//		
//				System.out.println("Nhập chuỗi: ");
//				str = scanner.nextLine();
//		
//				for (int i = 0; i < str.length(); i++) {
//					if (checkKeyNumber(str.charAt(i))) {
//						System.out.println("False");
//						return;
//					}
//				}
//				System.out.println("True");	

//			qs14

//				Scanner scanner = new Scanner(System.in);
//				String str;
//				char ch1, ch2;
//		
//				System.out.println("Nhập chuỗi: ");
//				str = scanner.nextLine();
//		
//				System.out.println("Nhập kí tự muốn chuyển: ");
//				ch1 = scanner.nextLine().toCharArray()[0];
//		
//				System.out.println("Nhập kí tự sẽ chuyển: ");
//				ch2 = scanner.nextLine().toCharArray()[0];
//		
//				for (int i = 0; i < str.length(); i++) {
//					if (str.charAt(i) == ch1) {
//						str = str.replace(ch1, ch2);
//					}
//				}
//		
//				System.out.println("Chuoi sau khi chuyen: " + str);

//			qs15

//				Scanner scanner = new Scanner(System.in);
//				String str;
//		
//				System.out.println("Chuỗi: ");
//				str = scanner.nextLine();
//		
//				str = str.replaceAll("\\s+", " ");
//				str = str.trim();
//		
//				String[] words = str.split(" ");
//				String result = "";
//				for (int i = words.length - 1; i >= 0; i--) {
//					result += words[i] + " ";
//				}
//				result.trim();
//				System.out.println(result);

//			qs16

//				Scanner scanner = new Scanner(System.in);
//				String str;
//				int n;
//		
//				System.out.println("Chuỗi: ");
//				str = scanner.nextLine();
//		
//				System.out.println("Nhập n: ");
//				n = scanner.nextInt();
//		
//				scanner.close();
//		
//				if (str == null || str.isEmpty() || str.length() % n != 0) {
//					System.out.println("No");
//					return;
//				}
//		
//				for (int i = 0; i < str.length(); i += n) {
//					System.out.println(str.substring(i, i + n));
//				}

//		ex5 Object’s Method
//		qs 3
//		System.out.println(department1.hashCode());

//		qs 4
//		System.out.println(department1.name.equals("Phòng A"));

//		qs5
//		System.out.println(department1.name.equals(department2.name));
	}

	private static String reverseWords(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");

		String[] words = str.split(" ");

		str = "";
		for (int i = words.length - 1; i >= 0; i--) {
			str += words[i] + " ";
		}

		return str.substring(0, str.length() - 2);
	}

	public static boolean checkKeyNumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}

	public static void accNew() {
		Account[] accounts = new Account[5];

		for (int i = 0; i < 5; i++) {
			Account account = new Account();
			account.email = "Email " + (i + 1);
			account.userName = "Username " + (i + 1);
			account.fullName = "Full name " + (i + 1);
			account.createDate = LocalDate.now();

			accounts[i] = account;
		}

		for (Account account : accounts) {
			System.out.println(account.email);
			System.out.println(account.userName);
			System.out.println(account.fullName);
			System.out.println(account.createDate);
			System.out.println("\n");
		}
	}
}
