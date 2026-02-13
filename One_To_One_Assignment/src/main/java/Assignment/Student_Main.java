package Assignment;

public class Student_Main {
	public static void main(String[] args) {
		Student_Driver dao = new Student_Driver();
		//dao.insertData();
		System.out.println(dao.fetchData(121));
		dao.showData();
		//dao.deleteData(121);
	}

}