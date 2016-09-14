package com.daxiang.excerise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.daxiang.domain.many2one_uni.Book;
import com.daxiang.domain.many2one_uni.Publisher;

public class Many2One_Uni {

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
		tx.begin();
		//this is not need to 
		Publisher pub1=new Publisher("WSJ");
		Book book1=new Book("isbn-001","game of throne","Dewei xiang");
		book1.setPublisher(pub1);
		Book book2=new Book("isbn-001","game of throne","Dewei xiang");
		book2.setPublisher(pub1);
		Book book3=new Book("isbn-001","game of throne","Dewei xiang");
		book3.setPublisher(pub1);
		//if set cascade.all then you don't need to persist the below line code
		//entityManager.persist(pub1);
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.persist(book3);
		tx.commit();

	}

}
