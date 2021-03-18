package Exception;

import java.util.ArrayList;

public class question4 {
	public static void main(String[] args) {
		int[] departments = { 1, 2, 3 };
		try {
			System.out.println(departments[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Cannot find department.");
		}
	}

	public void getIndex(int index) {
	}
}
