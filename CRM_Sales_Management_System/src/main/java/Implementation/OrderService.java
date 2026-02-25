package Implementation;


import javax.persistence.*;
import java.util.*;


public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer c = em.find(Customer.class, customerId);

        Order o = new Order();
        o.setCustomer(c);
        o.setOrderDate("2026-02-22");

        double total = 0;
        List<Product> products = new ArrayList<>();

        for (Long id : productIds) {
            Product p = em.find(Product.class, id);
            products.add(p);
            total += p.getPrice();
        }

        o.setProducts(products);
        o.setTotalAmount(total);

        em.persist(o);
        et.commit();
    }
}