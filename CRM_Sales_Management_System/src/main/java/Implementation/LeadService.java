package Implementation;


import javax.persistence.*;


public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    public void createLead(String name, String source, String contactInfo) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Lead l = new Lead();
        l.setName(name);
        l.setSource(source);
        l.setContactInfo(contactInfo);

        em.persist(l);
        et.commit();
    }

    public void assignLeadToEmployee(Long leadId, Long empId) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Lead l = em.find(Lead.class, leadId);
        SalesEmployee e = em.find(SalesEmployee.class, empId);
        l.setEmployee(e);

        et.commit();
    }

    public void convertLeadToCustomer(Long leadId) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Lead l = em.find(Lead.class, leadId);

        Customer c = new Customer();
        c.setName(l.getName());
        c.setEmail(l.getContactInfo());

        em.persist(c);
        em.remove(l);

        et.commit();
    }
}