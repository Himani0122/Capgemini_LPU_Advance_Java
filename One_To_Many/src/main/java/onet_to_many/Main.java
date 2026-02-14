package onet_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	public static void main(String[] args) {
//		insertData();
//		deletedata();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String s1 = "delete from college where id=?1";
		et.begin();
		Query q2 = em.createNativeQuery(s1);
		q2.setParameter(1, 3); //u are deleting from college but best practice is first delete from college_student
		q2.executeUpdate();
		et.commit();
	}
	public static void insertData() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setStu_id(101);
		s1.setBranch("CSE");
		s1.setName("Miller");
		
		Student s2 = new Student();
		s2.setStu_id(102);
		s2.setBranch("ECE");
		s2.setName("Mellon");
		
		College c = new College();
		c.setId(1);
		c.setLocation("Delhi");
		c.setName("ABC");
		c.setPincode("tuv");
		
//		College c1 = new College();
//		c.setId(2);
//		c.setLocation("Banglore");
//		c.setName("TUV");
//		c.setPincode("fds");
		
		List<Student> l = new ArrayList<>();
		l.add(s1);
		l.add(s2);
		c.setS(l);
		

		Student s3 = new Student();
		s3.setStu_id(103);
		s3.setBranch("BSC");
		s3.setName("Nishant");
		

		Student s4 = new Student();
		s4.setStu_id(104);
		s4.setBranch("MSC");
		s4.setName("Ayush");

		College c2 = new College();
		c2.setId(3);
		c2.setLocation("Hyderabad");
		c2.setName("GHY");
		c2.setPincode("ty3");
		
		List<Student> list = new ArrayList<>();
		list.add(s3);
		list.add(s4);
		
		c2.setS(list);
		
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		em.persist(c2);
		em.persist(s3);
		em.persist(s4);
		et.commit();
	}
	
	public static void deletedata() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//deleting college from college_student because while you are deleting college in college_student the data will remain same so first delete it
		String s2 = "delete from college_student where college_id=?1";
		et.begin();
		Query q3 = em.createNativeQuery(s2);
		q3.setParameter(1, 1); //u are deleting from college but best practice is first delete from college_student
		q3.executeUpdate();
		et.commit();
		
		//deleting data from college it wont throw any error because college has student not student has college
		String s1 = "delete from college where id=?1";
		et.begin();
		Query q2 = em.createNativeQuery(s1);
		q2.setParameter(1, 1); //u are deleting from college but best practice is first delete from college_student
		q2.executeUpdate();
		et.commit();
		
		//deleting data from college_student because if we dont delete it than student cannot be deleted
		String sql = "delete from college_student where s_stu_id =?1";
		et.begin();
		Query q = em.createNativeQuery(sql);
		q.setParameter(1, 101);
		q.executeUpdate();
		et.commit();
		
		//Now deleting data from student it wont throw any error
		String s = "delete from student where stu_id=?1";
		et.begin();
		Query q1 = em.createNativeQuery(s);
		q1.setParameter(1, 101);
		q1.executeUpdate();
		et.commit();
	}
}
