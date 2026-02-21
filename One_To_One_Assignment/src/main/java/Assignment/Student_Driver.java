package Assignment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Student_Driver{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void insertData() {
		Aadhar a = new Aadhar();
		a.setAadharId(1);
		a.setAddress("ABC");
		a.setIssueDate("01-01-2013");
		a.setNumber(12345);
		
		Hostel h = new Hostel();
		h.setBlockName("B");
		h.setRoomId(11);
		h.setFloorNumber("8");
		h.setRoomNumber(25);
		
		Student s = new Student();
		s.setAadharCard(a);
		s.setHostel(h);
		s.setBranch("CSE");
		s.setEmail("XYZ");
		s.setName("AYUSH");
		s.setStuId(121);
		
		et.begin();
		em.persist(a);
		em.persist(h);
		em.persist(s);		
		et.commit();
		
		em.close();
		
	}
	
	public Student fetchData(int id) {
		Student s = em.find(Student.class, id);
		if(s!=null) {
			return s;
		}
		return null;
	}
	
	public void deleteData(int id) {
		Student s = em.find(Student.class, id);
		if(s!=null) {
			et.begin();
			em.remove(s);
			et.commit();
		}
		else {
			System.out.println("Data does not exist");
		}
	}
	
	public void showData() {
		String jpql = "select s from Student s";
		Query q = em.createQuery(jpql);
		
		List<Student> list = q.getResultList();
		list.forEach(System.out::println);
	}
}