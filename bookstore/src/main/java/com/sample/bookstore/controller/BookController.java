package com.sample.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.bookstore.entity.Book;
import com.sample.bookstore.service.BookService;

@RestController
public class BookController {

	@Autowired 
	BookService bookService;
	
	@GetMapping("/test/{test}")
	public String gettest(@PathVariable("test") String test) {
		 
		System.out.println("Junit"+test);
		return test;
	}
	
	@GetMapping("/")
	public String getsampletest() {
		 
		System.out.println("Junit");
		return "junit";
	}
	
	
	@GetMapping("/book/author/{authorName}")
	@TrackExecutionTime
	public List<Book> getbookbyauthor(@PathVariable("authorName") String authorName) {
		 
	List<Book> books=	bookService.findbookbyauthor(authorName);
		return books;
	}

	
	@GetMapping("/book/title/{titleName}")
	@TrackExecutionTime
	public Book getbookbytitle(@PathVariable("titleName") String titleName) {
		 
		Book b=	bookService.findbookbytitle(titleName);
		return b;
	}
	
	@GetMapping("/book/isbn/{isbn}")
	@TrackExecutionTime
	public Book getbookbyisbn(@PathVariable("isbn") int isbn) {
		 
		Book b=	bookService.findbookbyisbn(isbn);
		return b;
	}
	
	
	//Add Book in bookstore
	
	@PostMapping("/addBook")
	@TrackExecutionTime
	public String addbook(@RequestBody Book book) {
		  System.out.println("adding book controller"+book);
		bookService.addBook(book);
		return book.getTitle()+"added successfully";
	}
	
	
	

	
	@GetMapping("/getCoverage/{title}")
	@TrackExecutionTime
	public List<String> getmediaCoverage( @PathVariable("title") String title) {
		
		return bookService.getmediaCoverage(title);
		
		
	}
	
	
	@PostMapping("/buyBook/customerId/{cusId}/bookIsbn/{isbn}")
	@TrackExecutionTime
	public String buyBook(@PathVariable("cusId") Integer cusId, @PathVariable("isbn")  Integer isbn) {
		
		
		 bookService.buyBook(cusId, isbn);
		 
		 return "Book Buy success";
		
	}
	
	
}
