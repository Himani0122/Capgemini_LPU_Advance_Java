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

	    @Test
	    public void testInsertProduct() {
	        Product p = new Product();
	        p.setId(5);
	        p.setName("Card Board");
	        p.setQuantity(17);
	        p.setPrice(220);

	        ProductDao.insertData(em, et, p);

	        Product fetched = em.find(Product.class, 5); 
	        assertNotNull(fetched);
	    }
	    
	    
	    
	    @Test
	    public void insertProductTestNull() {
	    	ProductDao pd = new ProductDao();
	    	
	    	String actualRes = pd.insertData(em, et, null);
	    	assertEquals("Data doesn't inserted",actualRes);
	    }

	    
	    public void testUpdateProduct() {
	        Product p = new Product();
	        p.setId(4);
	        p.setName("Book");
	        p.setQuantity(5);
	        p.setPrice(100);

	        ProductDao.insertData(em, et, p);

	        ProductDao.updateData(em, et, 4, 50);

	        Product updated = em.find(Product.class, 4);
	        assertEquals(50, updated.getQuantity());
	    }

	    
	    public void testDeleteProduct() {
	        Product p = new Product();
	        p.setId(5);
	        p.setName("Bag");
	        p.setQuantity(2);
	        p.setPrice(500);

	        ProductDao.insertData(em, et, p);

	        ProductDao.deleteData(em, et, 5);

	        Product deleted = em.find(Product.class, 5);
	        assertNull(deleted);
	    }
}
