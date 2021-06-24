package com.sample.bookstore.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.bookstore.entity.Book;
import com.sample.bookstore.entity.Customer;
import com.sample.bookstore.entity.MediaCoverage;
import com.sample.bookstore.repository.BookDAO;
import com.sample.bookstore.repository.CustomerDAO;

@Transactional
@Service
public class BookService {

	
	 private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	BookDAO bookDao;
	
	@Autowired
	CustomerDAO customerDao;
	
	
	public List<Book> findbookbyauthor(String authorName) {
		// TODO Auto-generated method stub
		return bookDao.findByAuthor(authorName);
	}

	public Book findbookbytitle(String titleName) {
		// TODO Auto-generated method stub
		return bookDao.findByTitle(titleName);
	}

	public Book findbookbyisbn(int isbn) {
		// TODO Auto-generated method stub
		return bookDao.findByIsbn(isbn);
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		  System.out.println("adding book"+book);
		bookDao.save(book);
	}

	public List<String> getmediaCoverage(String title) {
		
		List<String> titleList = new ArrayList<>();
		
		final String uri = "https://jsonplaceholder.typicode.com/posts";

		    RestTemplate restTemplate = new RestTemplate();
		   
		    ResponseEntity<MediaCoverage[]> response = restTemplate.getForEntity(uri, MediaCoverage[].class);
		   
		    MediaCoverage[] objects = response.getBody();    
		    
		    for(MediaCoverage m: objects) {
		    	
		    	if(m.getBody().contains(title) || m.getTitle().contains(title) ) {
		    		
		    		titleList.add(m.getTitle());
		    		
		    	}
		    	
		    }
		    
		    return titleList;
}

	public void buyBook(Integer cusId, Integer isbn) {
		
	Book b=	bookDao.findByIsbn(isbn);
    Customer c = customerDao.findByCustomerId(cusId);
	
	b.setCustomer(c);	
	
	bookDao.save(b);
	
		
	}

	
	
}
