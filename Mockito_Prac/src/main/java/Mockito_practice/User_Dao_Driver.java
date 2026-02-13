package Mockito_practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class User_Dao_Driver {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();

	public void insertUsers() {
		EntityTransaction et = em.getTransaction();

		User_Dao u = new User_Dao();
		u.setId(103);
		u.setName("Tiller");
		u.setBalance(60000.0);

		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public User_Dao findById(int id) {
		User_Dao a = em.find(User_Dao.class, id);
		return a;
	}

}
