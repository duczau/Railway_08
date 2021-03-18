package vti.polymorphism;

public class HinhChuNhat implements TinhToan{
	float dai = 2.4f;
	float rong = 3.3f;
	@Override
	public void Chuvi() {
		System.out.println("chu vi HCN: "+(dai+rong)*2);
		
	}
	@Override
	public void Dientich() {
		System.out.println("dien tich HCN: "+(dai*rong));		
	}
}
