import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestingAssignment12 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {

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

		// create Position
			Position position1 = new Position();
			position1.id = 1;
			position1.name = "Position 1";
						
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
			account1.department = department3;
			account1.position = position1;
	
			Account account2 = new Account();
			account2.id = 2;
			account2.email = "def@gmail.com";
			account2.userName = "def";
			account2.fullName = "D E F";
			account2.department = department3;

			Account account3 = new Account();
			account3.id = 3;
			account3.email = "gh@gmail.com";
			account3.userName = "gh";
			account3.fullName = "G H";
			account3.department = department3;

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

		// accounts
		Account[] accounts = { account1, account3 };
		Group[] groups = {group1, group2, group3};
		group3.account = accounts;
		group2.account = accounts;
		account1.department = department1;
		account2.group = groups;
	
		
		Account[] listAccounts = {account1, account2, account3};
		Department[] listDepartments = {department1, department2, department3};
		Group[] listGroups = {group1,group2,group3};

		
	// Testing Assignment 2
	// Exercise 1
//		Question 1	Kiểm tra account thứ 2
//		 Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//		"Nhân viên này chưa có phòng ban"
//		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
//			if (account2.department == null) {
//				System.out.println("Nhân viên này chưa có phòng ban");
//			} else {
//				System.out.println("Phòng ban của nhân viên này là " + account2.department.name);
//			}
		
		
	// Question 2
		
//			if (account2.group == null) {
//				System.out.println("Nhân viên này chưa có group");
//			} else if (account2.group.length == 1) {
//				System.out.println("Group của nhân viên này là "+ account2.group[0]);
//			} else if (account2.group.length == 2) {
//				System.out.println("Group của nhân viên này là "+ account2.group[0] + " va " + account2.group[1] );
//			} else if (account2.group.length == 3) {
//				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//			} else {
//				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//			}
		
		
		
	// Question 3
		
//			System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là " + account2.department.name);
		
		
		
	// Question 4 
//			System.out.println(account1.position.name == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");

	// Switch case
	// Question 5 
		
//			int a = group2.account.length;
//			switch (a) {
//			case 1:
//					System.out.println("Nhóm có một thành viên");
//				break;
//			case 2:
//					System.out.println("Nhóm có hai thành viên");
//				break;
//			case 3:
//					System.out.println("Nhóm có ba thành viên");
//				break;
//			default:
//					System.out.println("Nhóm có nhiều thành viên");
//			}
		
		
		
	// Question 6
		
//			switch (account2.group.length) {
//			case 0:
//				System.out.println("Nhân viên này chưa có group");
//				break;
//			case 1:
//				System.out.println("Group của nhân viên này là "+ account2.group[0]);
//				break;
//			case 2:
//				System.out.println("Group của nhân viên này là "+ account2.group[0] + " va " + account2.group[1] );
//				break;
//			case 3:
//				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//				break;
//			default:
//				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//			}
		
		
		
	//	QS 7
		
//			switch (account1.position.name) {
//			case "Dev":
//				System.out.println("Đây là Developer");
//				break;
//
//			default:
//				System.out.println("Người này không phải là Developer");
//				break;
//			}
		
		
		
	// Question 8
		
//			for (Account acc : listAccounts) {
//				System.out.println(acc.fullName);
//				System.out.println(acc.email);
//				System.out.println(acc.department.name + "\n");
//			}
		
		
	// Question 9
		
//			for (Department dept : listDepartments) {
//				System.out.println(dept.id);
//				System.out.println(dept.name + "\n");
//			}
		
		
		
	// Question 10
		
//			for (int i = 0; i < listAccounts.length; i++) {
//				System.out.println("Thông tin account thứ " + (i + 1) + " là: ");
//				System.out.println("Email: " + listAccounts[i].email);
//				System.out.println("Full name: " + listAccounts[i].fullName);
//				System.out.println("Phòng ban: " + listAccounts[i].department.name + "\n");
//			}
		
		
		
	// Question 11
		
//			for (int i = 0; i < listDepartments.length; i++) {
//				System.out.println("Thông tin account thứ " + (i+1) + " là: ");
//				System.out.println("Email: " + listDepartments[i].id);
//				System.out.println("Full name: " + listDepartments[i].name + "\n");
//			}
		
		
		
	// Question 12
		
//			for (int i = 0; i < listDepartments.length; i++) {
//				if (i<2) {
//					System.out.println("Thông tin account thứ " + (i + 1) + " là: ");
//					System.out.println("Email: " + listAccounts[i].email);
//					System.out.println("Full name: " + listAccounts[i].fullName);
//					System.out.println("Phòng ban: " + listAccounts[i].department.name + "\n");
//				}
//			}
		
		
		
	// Question 13
		
//			for (int i = 0; i < listDepartments.length; i++ ) {
//				if (i != 1) {
//					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
//					System.out.println("ID: " + listDepartments[i].id);
//					System.out.println("Name: " + listDepartments[i].name);
//				};		
//			}
		
		
		
	// Question 14
		
//			System.out.println("Thông tin các account nhỏ hơn 4 là :");
//			for (int i = 0; i < listAccounts.length; i++) {
//				if (listAccounts[i].id < 4) {
//					System.out.println("ID: " + listAccounts[i].id);
//					System.out.println("Name: " + listAccounts[i].fullName);
//				}
//			}
		
		
		
	// Question 15
		
//			for (int i = 1; i <= 20; i++) {
//				if (i % 2 == 0) {
//					System.out.println(i);
//				}
//			}
		
		
		
	// Question 16
		
		
		// Q16- 10
//			int i = 0;
//			while (i<2) {
//				System.out.println("Thông tin account thứ " + (i + 1) + " là: ");
//				System.out.println("Email: " + listAccounts[i].email);
//				System.out.println("Full name: " + listAccounts[i].fullName);
//				System.out.println("Phòng ban: " + listAccounts[i].department.name + "\n");
//				i++;
//			}
//		
		
		// Q16- 11
//			int i = 0;
//			while (listAccounts[i].id < 4) {
//				System.out.println("ID: " + listAccounts[i].id);
//				System.out.println("Name: " + listAccounts[i].fullName);
//				i++;
//			}
		
	
		// Q16-13.
//				int i = 0;
//				while (i < listDepartments.length) {
//
//					if (i == 1) {
//						i++;
//						continue;
//					}
//					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
//					System.out.println("ID: " + listDepartments[i].id);
//					System.out.println("Name: " + listDepartments[i].name);
//					i++;
//				}

		
//		// Q16-14.
//				int i = 0;
//				while (i < listAccounts.length) {
//					if (listAccounts[i].id >= 4) {
//						i++;
//						continue;
//					}
//					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
//					System.out.println("Email: " + listAccounts[i].email);
//					System.out.println("Fullname: " + listAccounts[i].fullName);
//					System.out.println("Department: " + listAccounts[i].department.name);
//					i++;
//				}

		
		// Q16-15.
//		
//			int i = 1;
//			while (i<=20) {
//				if (i%2==0) {
//					System.out.println(i);
//				}
//				i++;
//			}
		
		
		// Question 17
		
		
		// Q1- 10
//			int i = 0;
//			do {
//				System.out.println("Thông tin account thứ " + (i + 1) + " là: ");
//				System.out.println("Email: " + listAccounts[i].email);
//				System.out.println("Full name: " + listAccounts[i].fullName);
//				System.out.println("Phòng ban: " + listAccounts[i].department.name + "\n");
//				i++;
//			} while (i<2);
//			
		
		// Q16- 11
//				int i = 0;
//				do {
//					System.out.println("ID: " + listAccounts[i].id);
//					System.out.println("Name: " + listAccounts[i].fullName);
//					i++;
//				} while (listAccounts[i].id < 3);
		
	
		// Q16-13.
//				int i = 0;
//				do {
//
//					if (i == 1) {
//						i++;
//						continue;
//					}
//					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
//					System.out.println("ID: " + listDepartments[i].id);
//					System.out.println("Name: " + listDepartments[i].name);
//					i++;
//				} while (i < listDepartments.length);

		
//		// Q16-14.
//				int i = 0;
//				do {
//					if (listAccounts[i].id >= 4) {
//						i++;
//						continue;
//					}
//					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
//					System.out.println("Email: " + listAccounts[i].email);
//					System.out.println("Fullname: " + listAccounts[i].fullName);
//					System.out.println("Department: " + listAccounts[i].department.name);
//					i++;
//				} while (i < listAccounts.length);

		
		// Q16-15.
//		
//			int i = 1;
//			do {
//				if (i%2==0) {
//					System.out.println(i);
//				}
//				i++;
//			} while (i<=20);
		
		
	// break qs 12
		
//			for (int i = 0; i < listDepartments.length; i++) {
//				if (listDepartments[i].id >= 3) {
//					break;
//				}
//					System.out.println("Thông tin account thứ " + (i + 1) + " là: ");
//					System.out.println("Email: " + listAccounts[i].email);
//					System.out.println("Full name: " + listAccounts[i].fullName);
//					System.out.println("Phòng ban: " + listAccounts[i].department.name + "\n");
//				};
		
		
		
	// continue qs16
		
//			for (int i = 0; i < 20; i++) {
//				if (i%2==1 && i > 0) {
//					continue;
//				}
//				System.out.println(i);
//			}
		
		
		
//		Exercise 2 System out printf
//		Qs 1
//			int a = 5;
//			System.out.println(a);
			
		
//		qs 2
//			int b = 100000000;
//			System.out.printf("%,d%n", b);

		// Q3
//			float c = 5.567098f;
//			System.out.printf("%5.4f%n", c);

		// Q4
//			String s = "Nguyen Van A";
//			System.out.printf("Tên tôi là \"" + s + "\" và tôi đang độc thân \n");

		// Q5.
//			String pattern = "dd/MM/yyyy HH:mm:ss";
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//			String date = simpleDateFormat.format(new Date());
//			System.out.println(date);
		
//		QS 6
		
		
		
		
//		Exercise 3 (Optional): Date Format
//		qs 1
//			Locale locale = new Locale("vi", "VN");
//					
//			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
//			
//			String date = dateFormat.format(exam1.creatDate);
//			
//			System.out.println(exam1.id);
//			System.out.println(exam1.title);
//			System.out.println(exam1.code);
//			System.out.println(date);
		
//		 Qs2.
//				String pattern = "yyyy-MM-dd-HH-mm-ss";
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//				Exam[] exams = { exam1, exam2 };
//				for (Exam exam : exams) {
//					String date = simpleDateFormat.format(exam.creatDate);
//					System.out.println(exam.code + ": " + date);
//				};

//		 Qs 3.
//				String pattern = "yyyy";
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//				Exam[] exams = { exam1, exam2 };
//				for (Exam exam : exams) {
//					String date = simpleDateFormat.format(exam.creatDate);
//					System.out.println(exam.code + ": " + date);
//				}
//
//		 Qs 4.
//				String pattern = "yyyy-MM";
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//				Exam[] exams = { exam1, exam2 };
//				for (Exam exam : exams) {
//					String date = simpleDateFormat.format(exam.creatDate);
//					System.out.println(exam.code + ": " + date);
//				}
//
//		 Qs 5
//				String pattern = "MM-dd";
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//				Exam[] exams = { exam1, exam2 };
//				for (Exam exam : exams) {
//					String date = simpleDateFormat.format(exam.creatDate);
//					System.out.println(exam.code + ": " + date);
//				}
				
				
		
//		Exercise 4  Random Number
		
//				Random random = new Random();
//			random so nguyen
//				int x = random.nextInt(100);
//				System.out.println(x);
//			random tu 0 -> 10
//				int y = random.nextInt(10);
//				System.out.println(y);
//			random tu 10 -> 15
//				int z = random.nextInt(15-10+1) + 10;
//				System.out.println(z);
		
		
//		Random random = new Random();
		
//		QS 1
//			int a = random.nextInt();
//			System.out.println(a);
		
//		QS 2
//			double b = random.nextFloat();
//			System.out.println(b);
		
//		Qs 3
//			String[] names = { "Nguyen Mai", "Van Linh", "Hoa Lan" };
//			int i = random.nextInt(names.length);
//			System.out.println(names[i]);
//
//		Qs 4.
//			int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
//			int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
//			long randomInt = minDay + random.nextInt(maxDay - minDay);
//			LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
//			System.out.println(randomDay);
//
//		Qs 5.
//			int now = (int) LocalDate.now().toEpochDay();
//			long randomInt = now - random.nextInt(365);
//			LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
//			System.out.println(randomDay);
				
		
//		Qs 6
//			int pass = (int) LocalDate.now().toEpochDay();
//			long randomInt = pass - random.nextInt(pass);
//			LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
//			System.out.println(randomDay);
		
//		QS 7
//			int c = random.nextInt(900)+100;
//			boolean amduong = random.nextBoolean();
//			if (amduong) {
//				System.out.println(c);
//			} else {
//				System.out.println(c*-1);
//			}
		
		
		
//		exercise 5  Input from console

//		QS 1
		
//			Scanner scan = new Scanner(System.in);
//			int[] x = new int[3];
//			for (int i = 0; i < 3; i++) {
//				System.out.println("moi nhap so thu " + (i+1));
//				x[i] = scan.nextInt();
//			}
//			
//			for (int i : x) {
//				System.out.print(i+ " ");
//			}

		
//		QS 2
//		
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("moi nhap so dau: ");
//			float a = scanner.nextFloat();
//			
//			System.out.println("moi nhap so thu hai: ");
//			float b = scanner.nextFloat();
//			
//			System.out.println("so vua nhap la: ");
//			System.out.println(a);
//			System.out.println(b);
			
		
//		QS 3
//			
//			Scanner scan = new Scanner(System.in);
//			System.out.println("moi nhap ho: ");
//			String a = scan.next();
//			
//			System.out.println("moi nhap ten: ");
//			String b = scan.next();
//			
//			System.out.println("ho ten la: "+ a +" " + b);
		
		
//		QS 4
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Moi nhap vao ngay sinh");
//			String dateInput = scanner.next();
//			String pattern = "yyyy/MM/dd";
//			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//			Date date = dateFormat.parse(dateInput);
//			System.out.println("Input: " + date);
	
//		QS 5 tao account
//			inputAccount();
			
		
//		QS 6 tao department
//			inputDept();
			
//		Qs 7.
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("Moi ban nhap vao 1 so chan");
//				int number = scanner.nextInt();
//				if (number % 2 == 0) {
//					System.out.println("Input: " + number);
//				} else {
//					System.out.println("Nhap sai");
//				}
	
//		qs 8 
//			int a;
//			Scanner scanner = new Scanner(System.in);
//			do {
//				System.out.println("Moi nhap chuc nang: ");
//				int input = scanner.nextInt();
//				
//				switch (input) {
//				case 1:
//					System.out.println("tao account:");
//					inputAccount();
//					a = 1;
//					break;
//				case 2:
//					System.out.println("tao department");
//					inputDept();
//					a = 1;
//					break;
//				default:
//					System.out.println("Chi nhap chuc nang 1 va 2! Moi nhap lai !! \n");
//					a = 2;
//					continue;
//				}
//			} while (a == 2);
			
		
//		Exercise 6 :
//			QS 1
//				sochan();
		
//			QS 2
				
		
//			QS 3
//				songuyen();
		accNew(accounts);
	}
	
	public static void question4() {
		
		Scanner scan = new Scanner(System.in);	
		System.out.println("ngay thang: ");
		String a = scan.next();
		String pattern = "dd-mm-yyyy"; 
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		SimpleDateFormat da = dateFormat;
		System.out.println("ngay sinh la: ");
	}
	
	public static void inputDept() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap vao Department ID: ");
		int id = scanner.nextInt();
		
		switch (id) {
		case 1:
			System.out.println("Sales");
			break;
		case 2:
			System.out.println("CEO");
			break;
		case 3:
			System.out.println("Marketing");
			break;
		default:
			System.out.println("Nhap sai id, moi nhap lai!!");
			inputDept();
			break;
		}
	}
	
	public static void inputAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap vao Account ID:");
		int id = scanner.nextInt();

		scanner.nextLine();
		System.out.print("Nhap vao username:");
		String userName = scanner.nextLine();

		System.out.print("Nhap vao Department:");
		String department = scanner.nextLine();

		System.out.print("Nhap vao Position ID (tu 1 -> 5):");
		int position = scanner.nextInt(6);
		switch (position) {
		case 1:
			System.out.print("Dev");
			break;
		case 2:
			System.out.print("Test");
			break;
		case 3:
			System.out.print("ScrumMaster");
			break;
		case 4:
			System.out.print("PM");
			break;
		default:
			System.out.print("SA");
		}

		System.out.print("\nNhap vao group:");
		scanner.nextLine();
		String groups = scanner.nextLine();

		System.out.print("\nNhap vao ngay:");
		String date = scanner.nextLine();
	}
	
	
	public static void sochan() {
		for (int i = 1; i < 10; i++) {
			if (i%2==0) {
				System.out.println(i);
			}
		}
	};
	
	
	public static void songuyen() {
		for (int i = 1; i < 10; i++) {
				System.out.println(i);
		}
	}
	
	
	public static void accNew(Account[] accounts) {
		
		for (int i = 0; i < accounts.length; i++) {
			System.out.println();
		}
	}
	
}



