package com.daxiang.excerise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.daxiang.domain.many2one_bi_f.Department;
import com.daxiang.domain.many2one_bi_f.Employee;
import com.daxiang.domain.many2one_bi_f.Office;



public class Many2One_Bi_f {

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
		try {
			tx.begin();
			Department dep1 = new Department("Computer Science");
			Department dep2 = new Department("MBBA");
			
			Employee emp1 = new Employee("Dewei Xiang1");
			Employee emp2 = new Employee("Dewei Xiang2");
			emp1.setDepartment(dep1);
			dep1.getEmployees().add(emp1);
			dep1.getEmployees().add(emp2);
			dep1.getEmployees().add(new Employee("Dewei Xiang3"));
			
			dep2.getEmployees().add(new Employee("Dewei Xiang4"));
			
			Office office1=new Office("B141");
			Office office2=new Office("B140");
			emp1.setOffice(office1);
			emp2.setOffice(office2);
			entityManager.persist(dep1);
			entityManager.persist(dep2);
			entityManager.flush();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
