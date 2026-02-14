package EcommerceOrderModule;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main_Dao {
	public static void saveuser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Profile p = new Profile();
		p.setPid(1);
		p.setAddress("XYZ");
		p.setPhone(9018732992l);
		
		Profile p1 = new Profile();
		p1.setPid(2);
		p1.setAddress("SDA");
		p1.setPhone(943892292l);
		
		PurchaseOrder po=new PurchaseOrder();
		po.setAmount(2000.0);
		po.setOrderDate("19-feb-2026");
		po.setPoid(101);
		
		PurchaseOrder po1=new PurchaseOrder();
		po1.setAmount(3000.0);
		po1.setOrderDate("21-feb-2026");
		po1.setPoid(102);
		
		PurchaseOrder po3=new PurchaseOrder();
		po3.setAmount(3000.0);
		po3.setOrderDate("15-feb-2026");
		po3.setPoid(103);
		
		PurchaseOrder po4=new PurchaseOrder();
		po4.setAmount(3000.0);
		po4.setOrderDate("21-feb-2026");
		po4.setPoid(104);
		
		User u = new User();
		u.setId(1001);
		u.setEmail("abc@gmail.com");
		u.setName("ABC");
		u.setP(p1);
		
		List<PurchaseOrder> l = new ArrayList<>();
		l.add(po3);
		l.add(po4);
		
		u.setL(l);	
		
		et.begin();
		em.persist(p1);
		em.persist(po3);
		em.persist(po4);
		em.persist(u);
		et.commit();
	}
	public static void findUser(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql = "select * from users where id=?1";
		Query q = em.createNativeQuery(sql,User.class);
		q.setParameter(1, id);
		
		List<User> l = q.getResultList();
		l.forEach(x->System.out.println(x));
		
	}
	
	public static void deleteuser(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String s1 = "delete from profile where pid=?1";
		String s2 = "delete from users_purchaseorder where user_id=?1";
		String s3 = "delete from users where id=?1";
		
		et.begin();
		Query q1 = em.createNativeQuery(s1);
		q1.setParameter(1, id);
		Query q2 = em.createNativeQuery(s2);
		q2.setParameter(1, id);
		Query q3 = em.createNativeQuery(s3);
		q3.setParameter(1, id);
		q1.executeUpdate();
		q2.executeUpdate();
		q3.executeUpdate();
		et.commit();
	}
	
	public static void updateuser(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//String s = "update users set "
	}
}
