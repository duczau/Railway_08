package qs1_2;

public class main {
	public static void main(String[] args) {
		
		QLCB qlcb = new QLCB();
		qlcb.addCanbo();
		qlcb.addCanbo();
		qlcb.addCanbo();
		qlcb.showlist();
		qlcb.deleteCanbo("a");
		qlcb.showlist();
	}
}
