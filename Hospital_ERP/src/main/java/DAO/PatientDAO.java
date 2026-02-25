package DAO;

import javax.persistence.*;

import Entities.Patient;

import java.util.List;

public class PatientDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void insert(String name, String phone, int medRecordId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("INSERT INTO patient(name, phone, med_record_id) VALUES(?,?,?)");
        q.setParameter(1, name);
        q.setParameter(2, phone);
        q.setParameter(3, medRecordId);
        q.executeUpdate();

        et.commit();
        em.close();
    }

    public void updatePhone(int id, String phone) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("UPDATE patient SET phone=? WHERE id=?");
        q.setParameter(1, phone);
        q.setParameter(2, id);
        q.executeUpdate();

        et.commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("DELETE FROM patient WHERE id=?");
        q.setParameter(1, id);
        q.executeUpdate();

        et.commit();
        em.close();
    }

    public void projectNames() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p.name FROM Patient p");
        List<Patient> list = q.getResultList();

        for (Patient o : list) {
            System.out.println(o);
        }
        em.close();
    }

}