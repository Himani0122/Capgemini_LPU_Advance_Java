package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SQL_Query {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		select(emf,em);
		update(emf,em,et);
	}
	public static void select(EntityManagerFactory emf,EntityManager em) {
		String sql = "Select * from product";
		Query query = em.createNativeQuery(sql);
		List<Product> list = query.getResultList();
		System.out.println(list);
	}
	public static void update(EntityManagerFactory emf,EntityManager em,EntityTransaction et) {
		String sql = "Update product set price=?1 where price=?2";
		et.begin();
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, 15.0);
		query.setParameter(2, 10.0);
		query.executeUpdate();
		et.commit();
	}
	
}
