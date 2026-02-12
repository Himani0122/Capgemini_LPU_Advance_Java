package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Custome_Query_JPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		findbyname(emf,em);
		
		findbyid(emf,em);
		
		whereclause(emf,em);
		
		updatequery(emf,em,et);
	}
	public static void findbyid(EntityManagerFactory emf,EntityManager em) {
		String jpql = "select p from Product p where p.price=?1";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, 150.0);
		
		List<Product> list = query.getResultList();
		list.forEach(i->System.out.println(i.getName()+" "+i.getId()+" "+i.getPrice()+" "+i.getQuantity()));
	}
	public static void findbyname(EntityManagerFactory emf,EntityManager em) {
		String jpql = "select p from Product p where p.name = ?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, "Book");
		
		List<Product> list = query.getResultList();
		list.forEach(i->System.out.println(i.getName()+" "+i.getId()+" "+i.getPrice()+" "+i.getQuantity()));
	}
	
	public static void whereclause(EntityManagerFactory emf,EntityManager em) {
		String jpql = "select p from Product p where p.price>=?1 and p.quantity>=?2";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, 150.0);
		query.setParameter(2, 10);
		
		List<Product> list = query.getResultList();
		list.forEach(i->System.out.println(i.getName()+" "+i.getId()+" "+i.getPrice()+" "+i.getQuantity()));
	}
	
	public static void updatequery(EntityManagerFactory emf,EntityManager em,EntityTransaction et) {
		String jpql = "update Product p set p.price=:a where p.price=:b";
		
		et.begin();
		Query query = em.createQuery(jpql);
		query.setParameter("a", 120.0);
		query.setParameter("b", 100.0);
		
		query.executeUpdate();
		et.commit();
	}
}
