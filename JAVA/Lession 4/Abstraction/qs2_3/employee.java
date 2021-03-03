package qs2_3;

public class employee extends User {

	public employee(String name, double salary) {
		super(name, salary);
	}

	@Override
	public double calculatePay() {
		return salary*420;
	}

}
