package vti.polymorphism;

public class HinhVuong implements TinhToan{
	float canh = 15f;
	@Override
	public void Chuvi() {
		System.out.println("tinh chu vi HV: "+canh*4);
	}

	@Override
	public void Dientich() {
		System.out.println("tinh dien tich HV: "+canh*canh);
	}
	
}
