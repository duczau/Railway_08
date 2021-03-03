package qs2_3;

public class waiter extends User {
	public waiter(String name, double salary) {
		super(name, salary);
	}

	@Override
	public double calculatePay() {
		return salary*220;
	}
}
