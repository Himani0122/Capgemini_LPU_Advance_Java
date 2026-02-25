package DAO;


import javax.persistence.*;

public class MedicalRecordDAO {

    private EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    public void insert(String diagnosis, String notes) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("INSERT INTO medical_record(diagnosis, notes) VALUES(?,?)");
        q.setParameter(1, diagnosis);
        q.setParameter(2, notes);
        q.executeUpdate();

        et.commit();
        em.close();
    }
}