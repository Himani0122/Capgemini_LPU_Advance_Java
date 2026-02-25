package Implementation;


import javax.persistence.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        CustomerService customerService = new CustomerService(em);
        ProductService productService = new ProductService(em);
        LeadService leadService = new LeadService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);

        
        customerService.registerCustomer("Ayush", "ayush@gmail.com", "9999999999");

        
        Address addr = new Address();
        addr.setStreet("MG Road");
        addr.setCity("Delhi");
        addr.setState("Delhi");
        addr.setZipCode("110001");
        customerService.addAddressToCustomer(1L, addr);

        
        productService.addProduct("Laptop", 50000);
        productService.addProduct("Mouse", 500);

        
        leadService.createLead("Rahul", "Website", "rahul@gmail.com");

        EntityTransaction et = em.getTransaction();
        et.begin();
        SalesEmployee emp = new SalesEmployee();
        emp.setName("Rohit");
        emp.setDepartment("Sales");
        em.persist(emp);
        et.commit();

        leadService.assignLeadToEmployee(1L, 1L);

        leadService.convertLeadToCustomer(1L);

        
        List<Long> productIds = new ArrayList<>();
        productIds.add(1L);
        productIds.add(2L);
        orderService.placeOrder(1L, productIds);

        
        ticketService.raiseTicket(1L, "Product not working");

        em.close();
        emf.close();

        System.out.println("CRM operations completed.");
    }
}