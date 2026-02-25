package DAO;



import javax.persistence.*;

import Entities.Doctor;

import java.util.List;

public class DoctorDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void projectNames() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT d.name FROM Doctor d");
        List<Doctor> list = q.getResultList();

        for (Doctor o : list) {
            System.out.println(o);
        }
        em.close();
    }
}