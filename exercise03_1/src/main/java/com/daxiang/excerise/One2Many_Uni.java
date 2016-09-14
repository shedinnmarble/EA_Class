package com.daxiang.excerise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.daxiang.domain.one2many_uni.Customer;
import com.daxiang.domain.one2many_uni.Reservation;

public class One2Many_Uni {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		
		Customer customer1=new Customer("Dewei");
		
		Reservation res1=new Reservation("date1");
		Reservation res2=new Reservation("date2");
		Reservation res3=new Reservation("date3");
		customer1.getReservations().add(res1);
		customer1.getReservations().add(res2);
		customer1.getReservations().add(res3);
		tx.begin();
		entityManager.persist(customer1);
		tx.commit();
		// TODO Auto-generated method stub

	}

}
