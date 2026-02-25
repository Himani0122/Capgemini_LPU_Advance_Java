package firstlevelcahce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Product p1 = new Product();
//		p1.setId(1);
//		p1.setName("LUX");
//		
//		Product p2 = new Product();
//		p2.setId(2);
//		p2.setName("Santoor");
//		
//		et.begin();
//		em.persist(p1);
//		em.persist(p2);
//		et.commit();
		read();
	}
	public static void read() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("=========First Cache===========");
		Product p1 = em.find(Product.class, 1);
		System.out.println(p1.getName());
		
		System.out.println("=============Second Cache=============");
		EntityManager em2 = emf.createEntityManager();
		Product p2 = em2.find(Product.class, 1);
		System.out.println(p2.getName());
	}
}
