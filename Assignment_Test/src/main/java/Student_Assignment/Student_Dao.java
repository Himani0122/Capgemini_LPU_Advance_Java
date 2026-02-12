package Student_Assignment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Student_Dao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public String insertData(int id,int age,String name) {
		Student s = em.find(Student.class, id);
		if(s==null) {
			Student st = new Student();
			st.setId(id);
			st.setAge(age);
			st.setName(name);
			et.begin();
			em.persist(st);
			et.commit();
			return "Data inserted...";
		}
		else {
			return "Data already exist";
		}
	}
	
	
	public Student findData(int id) {
		Student s = em.find(Student.class, id);
		if(s!=null) {
			System.out.println(s);
			return s;
		}
		return null;
		
	}
	
	public Student updateData(int id,int newAge,String newName) {
		Student s = em.find(Student.class, id);
		if(s!=null) {
			s.setAge(newAge);
			s.setName(newName);
			et.begin();
			em.merge(s);
			et.commit();
			System.out.println(s);
			
			return s;
		}
		else {
			System.out.println("Data does not exist");
			return null;
		}
	}
	
	public String deleteData(int id) {
		Student s = em.find(Student.class,id);
		if(s!=null) {
			et.begin();
			em.remove(s);
			et.commit();
			return "Data deleted";
		}
		else {
			return "Data does not exist...";
		}
	}
	
	public List<Student> fetchTable(){
		String jpql = "select s from Student s";
		Query q = em.createQuery(jpql);
		
		List<Student> list = q.getResultList();
		return list;
	}
	
	

}