import com.vti.entity.Account;
import com.vti.entity.Group;

public class Constructor {

	public static void main(String[] args) {
//		Question 1:
//			Tạo constructor cho department:
//			a) không có parameters
//			b) Có 1 parameter là nameDepartment và default id của
//			Department = 0
//			Khởi tạo 1 Object với mỗi constructor ở trên

		Account creator = new Account();
		creator.id = 1;
		creator.setUsername("van A");
		
		String[] username = {"van a", "van b", "van c"};
		
		Group group = new Group(null, creator, username, null);
		
		
	}
}
