package qs2_3;

public class manager extends User {

	
	public manager(String name, double salary) {
		super(name, salary);
	}

	@Override
	public double calculatePay() {
		return salary*520;
	}

}
