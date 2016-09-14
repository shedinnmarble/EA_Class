package com.daxiang.domain.many2one_uni;

import javax.persistence.*;

@Entity
public class Publisher {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}
	public Publisher(String name) {
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


}
