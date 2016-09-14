package com.daxiang.domain.one2many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Reservation> reservations=new ArrayList<Reservation>();
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
