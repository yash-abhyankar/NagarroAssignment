package com.sample.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id 
	@NotNull(message = "Please provide a isbn") 
	private Integer isbn;  
	
	@NotEmpty(message = "Please provide a  title") 
	private String title;
	
	@NotEmpty(message = "Please provide a author") 
	private String author;
	
	@NotNull(message = "Please provide a price") 
	private Integer price;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
