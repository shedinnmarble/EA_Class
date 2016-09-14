package com.daxiang.domain.one2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int employeenumber;
	private String name;
	@ManyToOne
	//@JoinColumn(name="department_id")
	private Department department;
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
	
	
	
	
	

}
