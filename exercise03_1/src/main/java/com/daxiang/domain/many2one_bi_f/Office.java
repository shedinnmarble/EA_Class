package com.daxiang.domain.many2one_bi_f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Office {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int roomNumber;
	private String building;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Employee> employees=new ArrayList<Employee>();
	public Office() {
		// TODO Auto-generated constructor stub
	}
	public Office(String building) {
		super();
		this.building = building;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
