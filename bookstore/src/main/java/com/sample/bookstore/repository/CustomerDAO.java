package com.sample.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.bookstore.entity.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer>{

	
	Customer findByCustomerId(int id);
}
