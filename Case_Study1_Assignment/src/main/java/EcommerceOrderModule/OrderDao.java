package EcommerceOrderModule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OrderDao {
	public static void saveOrder() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		PurchaseOrder p = new PurchaseOrder();
		p.setAmount(35000.0);
		p.setOrderDate("15-feb-2026");
		p.setPoid(109);
		
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public static void findOrder(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql = "Select * from purchaseorder where poid=?1";
		Query q = em.createNativeQuery(sql,PurchaseOrder.class);
		q.setParameter(1, id);
		List<PurchaseOrder> l = q.getResultList();
		l.forEach(System.out::println);
		
	}
	
	public static void findOrdersByUser(Long Id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql = "Select * from purchaseorder where users.id=?1";
		Query q = em.createNativeQuery(sql,PurchaseOrder.class);
		q.setParameter(1, Id);
		List<PurchaseOrder> l = q.getResultList();
		l.forEach(System.out::println);
		
	}
}
