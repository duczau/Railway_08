package qs1_2;

public class KySu extends CanBo{
	public KySu(int tuoi, String name2, String gender2, String address2) {
		super(name2, tuoi, gender2, address2);
		// TODO Auto-generated constructor stub
	}

	private String nganh;
	
	public String getBac() {
		return nganh;
	};
	
	public void setBac(String nganh) {
		this.nganh = nganh;
	}
}
