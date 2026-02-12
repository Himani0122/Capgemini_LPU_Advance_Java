package Assignment_test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.*;

import Student_Assignment.Student;
import Student_Assignment.Student_Dao;

public class Student_Dao_Test {

    static EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Student_Dao dao;

    @BeforeAll
    public static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @AfterAll
    public static void close() {
        emf.close();
    }

    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        et = em.getTransaction();
        dao = new Student_Dao();

        et.begin();
        em.createQuery("DELETE FROM Student").executeUpdate();
        et.commit();
    }

    @AfterEach
    public void tearDown() {
        em.close();
    }

    @Test
    public void testSaveStudent() {
        String msg = dao.insertData(1, 20, "Rahul");
        assertEquals("Data inserted...", msg);
    }

    @Test
    public void testFindStudentById() {
        dao.insertData(1, 21, "Aman");
        Student s = dao.findData(1);
        assertNotNull(s);
        assertEquals(1, s.getId());
    }

    @Test
    public void testFindAllStudents() {
        dao.insertData(1, 20, "A");
        dao.insertData(2, 21, "B");

        List<Student> list = dao.fetchTable();
        assertEquals(2, list.size());
    }

    @Test
    public void testUpdateStudent() {
        dao.insertData(1, 20, "Ravi");
        Student s = dao.updateData(1, 25, "Ravi Kumar");

        assertNotNull(s);
        assertEquals(25, s.getAge());
        assertEquals("Ravi Kumar", s.getName());
    }

    @Test
    public void testDeleteStudent() {
        dao.insertData(1, 20, "Neha");
        String msg = dao.deleteData(1);

        assertEquals("Data deleted", msg);
        assertNull(dao.findData(1));
    }

    @Test
    public void testStudentCount() {
        dao.insertData(1, 20, "A");
        dao.insertData(2, 21, "B");
        dao.insertData(3, 22, "C");

        List<Student> list = dao.fetchTable();
        assertEquals(3, list.size());
    }
}