package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainDao {
	public static void insertData() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department d = new Department();
		d.setDid(101);
		d.setMname("M1");
		d.setName("XYZ");
		d.setNoofemp(10);
		
		Employee e = new Employee();
		e.setId(1);
		e.setDesignation("D1");
		e.setName("ABC");
		e.setSal(20000.0);
		e.setD(d);
		
		Employee e1 = new Employee();
		e1.setId(2);
		e1.setDesignation("D2");
		e1.setName("DEF");
		e1.setSal(30000.0);
		e1.setD(d);
		
		Department d2 = new Department();
		d2.setDid(102);
		d2.setMname("M1");
		d2.setName("YUG");
		d2.setNoofemp(25);
		
		Employee e2 = new Employee();
		e2.setId(3);
		e2.setDesignation("D2");
		e2.setName("GHI");
		e2.setSal(50000.0);
		e2.setD(d2);
		
		
		et.begin();
//		em.persist(d);
//		em.persist(e);
		em.persist(e1);
		em.persist(d2);
		em.persist(e2);
		et.commit();
		
	}
}
