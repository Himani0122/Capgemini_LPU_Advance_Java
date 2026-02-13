package Assignment_Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Assignment.Passport_Dao;


public class Passport_Test {

    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction et;

    @BeforeAll
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Test
    public void testInsertData() {
        Passport_Dao.insertData();
    }

    @Test
    public void testFindDataById() {
        boolean b = Passport_Dao.findDataById(101);
        assertTrue(b);
    }

    @Test
    public void testNullFindDataById() {
        boolean b = Passport_Dao.findDataById(999);
        assertFalse(b);
    }

    @Test
    public void testUpdateDataById() {
        boolean b = Passport_Dao.updateDataById(101, "Amit", 12);
        assertTrue(b);
    }

    @Test
    public void testNullUpdateDataById() {
        boolean b = Passport_Dao.updateDataById(999, "None", 0);
        assertFalse(b);
    }

    @Test
    public void testDeleteDataById() {
        Passport_Dao driver = new Passport_Dao();
        boolean b = driver.deleteDataById(101);
        assertTrue(b);
    }

    @Test
    public void testNullDeleteDataById() {
        Passport_Dao driver = new Passport_Dao();
        boolean b = driver.deleteDataById(999);
        assertFalse(b);
    }
}