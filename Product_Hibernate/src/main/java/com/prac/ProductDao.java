package com.prac;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ProductDao {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        insertDataFromUser(em, et);   // for normal run
    }

    // 🔹 For JUnit testing (NO Scanner)
    public static String insertData(EntityManager em, EntityTransaction et, Product p) {
    	if(p!=null) {
        et.begin();
        em.persist(p);
        et.commit();
        return "Data inserted";
    	}
    	else {
    		return "Data doesn't inserted";
    	}
    }

    // 🔹 For normal user input
    public static void insertDataFromUser(EntityManager em, EntityTransaction et) {
        Scanner sc = new Scanner(System.in);

        Product p = new Product();

        System.out.println("Enter ID:");
        p.setId(sc.nextInt());

        System.out.println("Enter Name:");
        p.setName(sc.next());

        System.out.println("Enter Quantity:");
        p.setQuantity(sc.nextInt());

        System.out.println("Enter Price:");
        p.setPrice(sc.nextDouble());

        insertData(em, et, p);
    }

    public static void deleteData(EntityManager em, EntityTransaction et, int id) {
        Product p = em.find(Product.class, id);

        if (p != null) {
            et.begin();
            em.remove(p);
            et.commit();
        }
    }

    public static void updateData(EntityManager em, EntityTransaction et, int id, int quantity) {
        Product p = em.find(Product.class, id);

        if (p != null) {
            et.begin();
            p.setQuantity(quantity);
            et.commit();
        }
    }

    public static Product findById(EntityManager em, int id) {
        return em.find(Product.class, id);
    }

    public static void findAll(EntityManager em) {
        Query q = em.createQuery("select p from Product_Assignment p");
        List<Product> list = q.getResultList();
        list.forEach(System.out::println);
    }
}