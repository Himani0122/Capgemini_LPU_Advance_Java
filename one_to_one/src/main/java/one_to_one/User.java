package one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

//		Engine e = new Engine();
//		e.setId(100);
//		e.setType("V8");
//		e.setType("Petrol");
//		e.setMileage("12");
//		e.setCc("3000");
//
//		Car c = new Car();
//		c.setId(1);
//		c.setBrand("Volkswagen");
//		c.setModel("Polo GT10");
//		c.setModelyear("2019");
//		c.setPrice(10000000);
//		c.setE(e);
//
//		et.begin();
//		em.persist(e);
//		em.persist(c);
//		et.commit();
		
		//findCarbyid(emf,em,1);
		deleteengine(emf,em,et,100);
	}
	
	public static void findCarbyid(EntityManagerFactory emf,EntityManager em,int id) {
		Car c = em.find(Car.class, id);
		System.out.println(c);
	}
	public static void deleteengine(EntityManagerFactory emf,EntityManager em,EntityTransaction et,int eid) {
		Car c = em.find(Car.class, eid);
		String jql = "Update car set e_id=null where e_id=?1";
		String jpql = "Delete from engine where id=?1";
		
		et.begin();
		Query query = em.createNativeQuery(jql);
		Query q2 = em.createNativeQuery(jpql);
		query.setParameter(1, eid);
		q2.setParameter(1, eid);
		query.executeUpdate();
		q2.executeUpdate();
		et.commit();
	}
}
