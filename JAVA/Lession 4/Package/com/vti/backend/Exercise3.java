package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Group;

public class Exercise3 {
	public void Qs3() {
		// a
		Group group = new Group();
		System.out.println(group);

		// b

		Account creator = new Account(1, "mail 1", "a", "b", "c", "d");
		Account acc1 = new Account(2, "mail 2", "A", "B", "C", "D");
		Account acc2 = new Account(3, "mail 3", "e", "f", "g", "h");

		// c
	}
}
