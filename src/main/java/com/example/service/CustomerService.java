package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void insertNewCustomer(Customer customer) {
	 customerRepository.save(customer);	
	}
	
	public Optional<List<Customer>> findByFirstName(String firstName){
		return customerRepository.findByFirstName(firstName);
	}

	public Optional<List<Customer>> findByLastName(String lastName){
		return customerRepository.findByLastName(lastName);
	}
	
	public Optional<List<Customer>> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable){
		return customerRepository.findByFirstNameAndLastName(firstName, lastName, pageable);
	}
	
}
