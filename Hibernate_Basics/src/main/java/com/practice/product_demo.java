package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class product_demo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		//for crud operations
		EntityManager em = emf.createEntityManager();
				
		//To commit
		EntityTransaction et = em.getTransaction();
		insert(em, et);
		//delete(em,et);
		//update(em,et);
		//findi(em);
		//findAll(em);
	}
	public static void insert(EntityManager em,EntityTransaction et) {
		Product p = new Product();
		p.setId(3);
		p.setName("Pen");
		p.setPrice(10);
		p.setQuantity(9);
		
		et.begin();
        em.persist(p);
        et.commit();

        System.out.println("Product inserted");
	}
	
	public static void delete(EntityManager em,EntityTransaction et) {
		Product p = em.find(Product.class, 1);
		et.begin();
		em.remove(p);
		et.commit();
		System.out.println("product Deleted");
	}
	public static void update(EntityManager em, EntityTransaction et) {
        Product p = em.find(Product.class, 2);

        if (p != null) {
            et.begin();
            p.setPrice(250000);   
            p.setQuantity(3);     
            et.commit();
            System.out.println("Product updated");
        } else {
            System.out.println("Product not found");
        }
	}
	public static void findi(EntityManager em) {
        Product p = em.find(Product.class, 2);

        if (p != null) {
           System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getQuantity());
        } else {
            System.out.println("Product not found");
        }
    }
	public static void findAll(EntityManager em) {
		String jpql = "Select p from Product p";
        Query q = em.createQuery(jpql);
        List<Product> list = q.getResultList();
        list.forEach(System.out::println);
    }
	
}
