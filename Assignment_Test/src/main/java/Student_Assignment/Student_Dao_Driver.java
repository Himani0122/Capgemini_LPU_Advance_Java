package Student_Assignment;


import java.util.List;

public class Student_Dao_Driver {
	public static void main(String[] args) {
		Student_Dao s = new Student_Dao();
		System.out.println(s.insertData(1, 13, "Ayush"));
		System.out.println(s.insertData(2, 17, "Himani"));
		System.out.println(s.insertData(3, 21, "Aditya"));
		
		Student s1 = s.findData(1);
		System.out.println(s1);
		
		System.out.println(s.updateData(2, 22, "Nidhi"));
		
		System.out.println(s.deleteData(3));
		
		System.out.println("Printing the Table:");
		List<Student> list = s.fetchTable();
		list.forEach(System.out::println);
	}

}