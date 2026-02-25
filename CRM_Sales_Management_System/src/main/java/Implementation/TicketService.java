package Implementation;


import javax.persistence.*;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void raiseTicket(Long orderId, String issue) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Order o = em.find(Order.class, orderId);

        SupportTicket t = new SupportTicket();
        t.setIssueDescription(issue);
        t.setOrder(o);

        em.persist(t);
        et.commit();
    }
}