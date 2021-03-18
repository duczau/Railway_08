package entity;

public class Car extends Vehicle implements QLphuongtienVersion1{

	public Car() {
		super();
		this.wheel = 4;
	}

	@Override
	public void di() {
		System.out.println("oto di bang "+wheel+" banh xe");
	}

	@Override
	public void napnhienlieu(String type, int color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void napnhienlieu() {
		// TODO Auto-generated method stub
		
	}

}
