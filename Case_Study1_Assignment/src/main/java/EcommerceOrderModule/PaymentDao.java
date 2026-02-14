package EcommerceOrderModule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PaymentDao {
	public static void savepayment(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		PurchaseOrder p = new PurchaseOrder();
		p.setAmount(45000.0);
		p.setOrderDate("17-feb-2026");
		p.setPoid(110);
		
		Payment p1 = new Payment();
		p1.setPa_id(10001);
		p1.setAmount(34000.0);
		p1.setMode("A");
		p1.setP(p);
		
		et.begin();
		em.persist(p);
		em.persist(p1);
		et.commit();
	}
	public static void findpayment(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Payment p = em.find(Payment.class, id);
		System.out.println(p);
	}
}
