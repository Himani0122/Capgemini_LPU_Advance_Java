package Assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Passport_Dao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

    public static void insertData() {
        Passport p = new Passport();
        p.setPassportNo(101);
        p.setName("Rahul");
        p.setGender("Male");
        p.setAddress("Delhi");
        p.setNoOfTravel(5);

        et.begin();
        em.persist(p);
        et.commit();
    }

    public static boolean findDataById(int id) {
        Passport p = em.find(Passport.class, id);
        if (p != null) {
            System.out.println(p);
            return true;
        }
        return false;
    }

    public static boolean updateDataById(int id, String newName, int newTravel) {
        Passport p = em.find(Passport.class, id);
        if (p != null) {
            et.begin();
            p.setName(newName);
            p.setNoOfTravel(newTravel);
            et.commit();
            System.out.println("Updated: " + p);
            return true;
        }
        return false;
    }

    public boolean deleteDataById(int id) {
        Passport p = em.find(Passport.class, id);
        if (p != null) {
            et.begin();
            em.remove(p);
            et.commit();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        insertData();
        findDataById(101);
        updateDataById(101, "Rohit", 10);
    }
}
