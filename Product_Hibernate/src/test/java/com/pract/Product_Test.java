package com.pract;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prac.Product;
import com.prac.ProductDao;

public class Product_Test {

    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction et;

    @BeforeAll
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

//    @BeforeEach
//    public void cleanDatabase() {
//        et.begin();
//        em.createQuery("DELETE FROM Product").executeUpdate();
//        et.commit();
//    }

    @Test
    public void testInsertProduct() {
        Product p = new Product();
        p.setId(2);
        p.setName("Pen");
        p.setQuantity(10);
        p.setPrice(20.5);

        ProductDao.insert(p, em, et);
        Product fetched = em.find(, p)
        assertEquals("Product inserted successfully", );
    }

//    @Test
//    public void testUpdateProduct() {
//        Product p = new Product();
//        p.setId(2);
//        p.setName("Book");
//        p.setQuantity(5);
//        p.setPrice(100);
//
//        ProductDao.insert(p, em, et);
//
//        ProductDao.update(2, 50, 200, em, et);
//
//        Product updated = ProductDao.findById(2, em);
//
//        assertNotNull(updated);
//        assertEquals(50, updated.getQuantity());
//        assertEquals(200, updated.getPrice());
//    }
//
//    @Test
//    public void testDeleteProduct() {
//        Product p = new Product();
//        p.setId(3);
//        p.setName("Bag");
//        p.setQuantity(2);
//        p.setPrice(500);
//
//        ProductDao.insert(p, em, et);
//
//        ProductDao.delete(3, em, et);
//
//        Product deleted = ProductDao.findById(3, em);
//
//        assertNull(deleted);
//    }
//
//    @AfterAll
//    public static void close() {
//        em.close();
//        emf.close();
//    }
}
