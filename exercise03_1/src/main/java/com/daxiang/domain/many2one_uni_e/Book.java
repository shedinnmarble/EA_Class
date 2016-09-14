package com.daxiang.domain.many2one_uni_e;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private int id;
	private String isbn;
	private String title;
	private String author;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}
