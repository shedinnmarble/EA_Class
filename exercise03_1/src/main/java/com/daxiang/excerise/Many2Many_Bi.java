package com.daxiang.excerise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.daxiang.domain.many2many_bi.Course;
import com.daxiang.domain.many2many_bi.Student;

public class Many2Many_Bi {
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
		Student st1=new Student("Dewei1","Xiang");
		Student st2=new Student("Dewei2","Xiang");
		Student st3=new Student("Dewei3","Xiang");
		Course c1=new Course("cs102","Algorithm");
		Course c2=new Course("cs103","Algorithm");
		Course c3=new Course("cs104","Algorithm");
		st1.getCourses().add(c1);
		st1.getCourses().add(c2);
		st1.getCourses().add(c3);
		
		st2.getCourses().add(c1);
		st2.getCourses().add(c2);
		st2.getCourses().add(c3);
		
		c1.getStudents().add(st1);
		c1.getStudents().add(st2);
		c1.getStudents().add(st3);
		entityManager.persist(st1);
		entityManager.persist(st2);
		tx.commit();

	}

}
