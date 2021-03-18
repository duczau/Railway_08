package entity;

public class Motobike extends Vehicle{
	public Motobike() {
		super();
		this.wheel = 2;
	}

	@Override
	public void di() {
		System.out.println("xe may di bang "+wheel+" banh xe");
	}
}
