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
	
	@GetMapping("/book/author/{authorName}")
	private List<Book> getbookbyauthor(@PathVariable("authorName") String authorName) {
		 
	List<Book> books=	bookService.findbookbyauthor(authorName);
		return books;
	}

	
	@GetMapping("/book/title/{titleName}")
	private Book getbookbytitle(@PathVariable("titleName") String titleName) {
		 
		Book b=	bookService.findbookbytitle(titleName);
		return b;
	}
	
	@GetMapping("/book/isbn/{isbn}")
	private Book getbookbyisbn(@PathVariable("isbn") int isbn) {
		 
		Book b=	bookService.findbookbyisbn(isbn);
		return b;
	}
	
	
	//Add Book in bookstore
	
	@PostMapping("/addBook")
	private String addbook(@Valid @RequestBody Book book) {
		bookService.addBook(book);
		return book.getTitle()+"added successfully";
	}
	
	
	

	
	@GetMapping("/getCoverage/{title}")
	private List<String> getmediaCoverage( @PathVariable("title") String title) {
		
		return bookService.getmediaCoverage(title);
		
		
	}
	
}
