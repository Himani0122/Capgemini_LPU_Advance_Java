package OneToOneByDefaultEagerToLazy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {
	

	    public static void insertCarAndEngine() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Engine e = new Engine();
	        e.setId(100);
	        e.setType("V8");
	        e.setFuelType("Petrol");
	        e.setMileage("12");
	        e.setCc("3000");

	        Car c = new Car();
	        c.setId(1);
	        c.setBrand("Volkswagen");
	        c.setModel("Polo GT10");
	        c.setModelYear("2019");
	        c.setPrice(10000000);
	        c.setEngine(e);

	        et.begin();
	        em.persist(e);
	        em.persist(c);
	        et.commit();

	        em.close();
	        emf.close();
	    }

	    public static void findCarById(int id) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	        EntityManager em = emf.createEntityManager();

	        Car c = em.find(Car.class, id);
	        if (c != null) {
	            System.out.println(c);
	            System.out.println("Particular Engine details: " 
	                    + c.getEngine().getFuelType() + " " + c.getEngine().getCc());
	        } else {
	            System.out.println("Car not found");
	        }

	        em.close();
	        emf.close();
	    }

	    public static void deleteEngineById() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Engine e = em.find(Engine.class, 100);

	        // if(e!=null) {
	        //     et.begin();
	        //     em.remove(e);   //But we can't delete Engine because it is a foreign key in Car class.
	        //     //So we need to break the connection i.e make the Engine_id null so that connection breaks;
	        //     //so we will make an update method in which first we will update the car's engine_id to null then delete the row where id=100 in the engine table
	        //     et.commit();
	        // }
	        // else {
	        //     System.out.println("Data does not exist");
	        // }

	        // So after creating update method now I will delete the row of Engine table where id=100.
	        if (e != null) {
	            String s1 = "update car set engine_id=null where engine_id=?1";
	            String s2 = "delete from engine where id=?1";

	            Query q1 = em.createNativeQuery(s1);
	            Query q2 = em.createNativeQuery(s2);

	            q1.setParameter(1, 100);
	            q2.setParameter(1, 100);

	            et.begin();
	            q1.executeUpdate();
	            q2.executeUpdate();
	            et.commit();

	            System.out.println("Engine row deleted where id =100 in Engine table...");
	        } else {
	            System.out.println("Data does not exist");
	        }

	        em.close();
	        emf.close();
	    }

	    public static void main(String[] args) {
	         insertCarAndEngine();
	         findCarById(1);
	        //deleteEngineById();
	    }



}