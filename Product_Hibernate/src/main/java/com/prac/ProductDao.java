package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p = new Product();
		p.setId(4);
		p.setName("Pencil");
		p.setQuantity(10);
		p.setPrice(20.5);

		ProductDao.insert(p, em, et);

		Product fetched = ProductDao.findById(1, em);
		System.out.println(fetched);

	}
    // INSERT
    public static void insert(Product p, EntityManager em, EntityTransaction et) {
        et.begin();
        em.persist(p);
        et.commit();
		System.out.println("Product inserted successfully");
    }

    // DELETE
    public static void delete(int id, EntityManager em, EntityTransaction et) {
        Product p = em.find(Product.class, id);

        if (p != null) {
            et.begin();
            em.remove(p);
            et.commit();
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    // UPDATE
    public static void update(int id, int quantity, double price,
                              EntityManager em, EntityTransaction et) {

        Product p = em.find(Product.class, id);

        if (p != null) {
            et.begin();
            p.setQuantity(quantity);
            p.setPrice(price);
            et.commit();
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    // FIND BY ID
    public static Product findById(int id, EntityManager em) {
        return em.find(Product.class, id);
    }

    // FIND ALL
    public static List<Product> findAll(EntityManager em) {
        String jpql = "SELECT p FROM Product p";
        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
        return query.getResultList();
    }
}
