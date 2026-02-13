package person_Practice_Assignment;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Person_Practice_Assignment.Person_Driver;

public class Person_Practice_Test {
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction et;
	
	@BeforeAll
	public static void setup() {
		emf=Persistence.createEntityManagerFactory("postgres");
		em=emf.createEntityManager();
		et=em.getTransaction();
	}
	
	@Test
	public void testInsertData() {
		Person_Driver.insertData();
	}
	
	@Test
	public void testFindDataById() {
		boolean b=Person_Driver.findDataById(4);
		assertTrue(b);
	}
	
	@Test
	public void testNullFindDataById() {
		boolean b = Person_Driver.findDataById(20);
		assertFalse(b);
	}
	
	@Test
	public void testUpdateDataById() {
	    boolean b = Person_Driver.updateDataByIdea(4, "Adi", 987654);
	    assertTrue(b);
	}
	
	@Test
	public void testNullUpdateDataById() {
	    boolean b = Person_Driver.updateDataByIdea(999, "None", 111111);
	    assertFalse(b);
	}

	@Test
	public void testDeleteDataById() {
	    Person_Driver p = new Person_Driver();
	    boolean b = p.deleteDataById(4);
	    assertTrue(b);
	}
	
	
	@Test
	public void testNullDeleteDataById() {
	    Person_Driver driver = new Person_Driver();
	    boolean b = driver.deleteDataById(999);
	    assertFalse(b);
	}

	
}
