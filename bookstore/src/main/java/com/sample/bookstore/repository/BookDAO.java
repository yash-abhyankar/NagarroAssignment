package com.sample.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sample.bookstore.entity.Book;

public interface BookDAO extends CrudRepository<Book, Integer> {

	List<Book> findByAuthor(String author);
	Book findByTitle(String title);
	Book findByIsbn(int isbn);
	
	
}
