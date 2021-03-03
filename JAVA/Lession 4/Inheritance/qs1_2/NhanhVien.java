package qs1_2;

public class NhanhVien extends CanBo{
	public NhanhVien(int tuoi, String name2, String gender2, String address2) {
		super(name2, tuoi, gender2, address2);
	}

	private int job;
	
	public int getBac() {
		return job;
	};
	
	public void setBac(int job) {
		this.job = job;
	}
}
