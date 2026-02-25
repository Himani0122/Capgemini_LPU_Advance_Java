package Implementation;



import javax.persistence.*;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public void addProduct(String name, double price) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        em.persist(p);
        et.commit();
    }
}