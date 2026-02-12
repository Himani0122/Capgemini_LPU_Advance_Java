package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		//for crud operations
		EntityManager em = emf.createEntityManager();
				
		//To commit
		EntityTransaction et = em.getTransaction();
				
		Student s = new Student();
		s.setId(1);
		s.setName("Himani");
		s.setPercentage(100);
		s.setDob("15-Nov-2004");

		//To Insert the data
//		et.begin();
//		em.persist(s);
//		et.commit();
		
		//To fetch the data
		//Student e = em.find(Student.class, 2);
		//System.out.println(e.getId()+" "+e.getName()+" "+e.getPercentage()+" "+ec.getDob());
		//To remove the data
//		et.begin();
//		em.remove(e);
//		et.commit();
		
//		//To update the data
//		if(e!=null) {
//			e.setDob("15-11-2004");
//			et.begin();
//			em.merge(e);
//			et.commit();
//		}
		
		//To fetch all the data
		String jpql = "Select s from Student s";
		Query q = em.createQuery(jpql);
		List<Student> l = q.getResultList();
		l.forEach(System.out::println);
		emf.close();
	}
}
