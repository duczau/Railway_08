package qs2_3;

public class backend {
	public void qs2_3() {
		employee employee = new employee("a", 1.2);
		employee.displayInfo();
		
		manager manager = new manager("ceo", 5);
		manager.displayInfo();
		
		waiter waiter = new waiter("b", 2.0);
		waiter.displayInfo();
	}
}
