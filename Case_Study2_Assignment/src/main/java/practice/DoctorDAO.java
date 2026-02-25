package practice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void insertDoctor(int id, String name, String specialization, List<Appointment> appointments) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Doctor d = new Doctor();
        d.setId(id);
        d.setName(name);
        d.setSpecialization(specialization);

        if (appointments != null) {
            d.setList(appointments);
        } else {
            d.setList(new ArrayList<>());
        }

        et.begin();
        em.persist(d);
        et.commit();
        em.close();
    }

    public static Doctor findDoctor(int id) {
        EntityManager em = emf.createEntityManager();
        Doctor d = em.find(Doctor.class, id);
        em.close();
        return d;
    }

    public static void updateDoctor(int id, String name, String specialization) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Doctor d = em.find(Doctor.class, id);
        if (d != null) {
            et.begin();
            d.setName(name);
            d.setSpecialization(specialization);
            et.commit();
        }
        em.close();
    }

    public static void deleteDoctor(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.createNativeQuery("delete from Doctor_Appointment where Doctor_id = ?1")
          .setParameter(1, id)
          .executeUpdate();

        em.createNativeQuery("delete from Doctor where id = ?1")
          .setParameter(1, id)
          .executeUpdate();

        et.commit();
        em.close();
    }

}