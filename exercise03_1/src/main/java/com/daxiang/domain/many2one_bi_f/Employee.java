package com.daxiang.domain.many2one_bi_f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int employeenumber;
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="department_id")
	private Department department;
	@ManyToOne(cascade=CascadeType.ALL)
	private Office office;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	public int getEmployeenumber() {
		return employeenumber;
	}
	public void setEmployeenumber(int employeenumber) {
		this.employeenumber = employeenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
	
	
	
	

}
