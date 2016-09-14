package com.daxiang.domain.many2one_uni_e;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int id;
	private String date;
	@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="dd_book_id")
	private Book book;
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

}
