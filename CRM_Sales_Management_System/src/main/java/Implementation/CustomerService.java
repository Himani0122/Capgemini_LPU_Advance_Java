package Implementation;


import javax.persistence.*;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);

        em.persist(c);
        et.commit();
    }

    public void addAddressToCustomer(Long customerId, Address address) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer c = em.find(Customer.class, customerId);
        em.persist(address);
        c.setAddress(address);

        et.commit();
    }
}