package DAO;

import javax.persistence.*;

public class PrescriptionDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void insert(String medicine, String dosage) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("INSERT INTO prescription(medicine, dosage) VALUES(?,?)");
        q.setParameter(1, medicine);
        q.setParameter(2, dosage);
        q.executeUpdate();

        et.commit();
        em.close();
    }
}