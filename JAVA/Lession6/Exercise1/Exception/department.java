package Exception;

public class department {
	private int id;
	private String name;

	public department() {
		input();
	}

	public department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void input() {
		System.out.println("Nhap id: ");
		id = question6_7_8.inputPositiveInt("hay nhap vao 1 so");
		
		System.out.println("Nhap name: ");
		name = question6_7_8.inputString();
	}

	@Override
	public String toString() {
		return "department [id=" + id + ", name=" + name + "]";
	}
}
