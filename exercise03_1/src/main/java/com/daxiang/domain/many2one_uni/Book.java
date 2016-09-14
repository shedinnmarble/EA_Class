package com.daxiang.domain.many2one_uni;

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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name="book_publisher")
	private Publisher publisher;
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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
