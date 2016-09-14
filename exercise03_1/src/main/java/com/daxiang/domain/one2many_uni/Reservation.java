package com.daxiang.domain.one2many_uni;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int id;
	private String date;
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	public Reservation(String date) {
		super();
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
