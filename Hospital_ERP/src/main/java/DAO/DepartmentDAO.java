package DAO;


import javax.persistence.*;

public class DepartmentDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void insert(String name) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("INSERT INTO department(name) VALUES(?)");
        q.setParameter(1, name);
        q.executeUpdate();

        et.commit();
        em.close();
    }
}