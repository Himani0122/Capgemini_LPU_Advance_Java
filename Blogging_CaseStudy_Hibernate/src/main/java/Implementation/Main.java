package Implementation;

import javax.persistence.*;

public class Main{
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User u1 = new User();
        u1.setName("Ayush");
        u1.setPassword("1234");
        u1.setEmail("ayush@gmail.com");

        Post p1 = new Post();
        p1.setTitle("Inside out");
        p1.setContent("Late night with homies");
        p1.setCreatedAt("12-08-2024");
        p1.setUpdatedAt("21-04-2025");
        p1.setAuthor(u1);

        Comment c1 = new Comment();
        c1.setContent("Nice post!");
        c1.setCreatedAt("12-12-2025");
        c1.setPost(p1);
        c1.setAuthor(u1);

        et.begin();
        em.persist(u1);
        em.persist(p1);
        em.persist(c1);
        et.commit();

        em.close();
        emf.close();
        
    }
}