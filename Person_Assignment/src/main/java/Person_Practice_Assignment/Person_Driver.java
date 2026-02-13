package Person_Practice_Assignment;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Person_Driver {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	static EntityManager em = emf.createEntityManager();	
	static EntityTransaction et = em.getTransaction();
	
	
	public static void insertData() {
		Person p = new Person();
		p.setId(5);
		p.setName("Pinku");
		p.setDob("28-10-1990");
		p.setPincode(196785);
		et.begin();
		em.persist(p);
		et.commit();
		
	}
	
	public boolean deleteDataById(int id) {
		Person p = em.find(Person.class,id);
		if(p!=null) {
			em.remove(p);
			return true;
		}
		return false;
	}
	
	public static boolean findDataById(int id) {
		Person p = em.find(Person.class,id);
		if(p!=null) {
			System.out.println(p);
			return true;
		}
		return false;
	}
	
	public static boolean updateDataByIdea(int id,String newname,int newpincode) {
		Person p = em.find(Person.class,id);
		if(p!=null) {
			p.setName(newname);
			p.setPincode(newpincode);
			System.out.println("Updated Data: "+p);
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		Person_Driver.insertData();
		Person_Driver.findDataById(1);
		Person_Driver.updateDataByIdea(1,"Adi", 987654);
		
		
		}

}
