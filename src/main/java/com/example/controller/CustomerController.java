package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.utility.RandomDateGenerator;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/insert")
	public void insertCustomers() {
		customerService.insertNewCustomer(new Customer("Jack", "Bauer", RandomDateGenerator.getRandomDate()));
		customerService.insertNewCustomer(new Customer("alan", "parry", RandomDateGenerator.getRandomDate()));
		customerService.insertNewCustomer(new Customer("barry", "richards", RandomDateGenerator.getRandomDate()));
		customerService.insertNewCustomer(new Customer("dan", "watson", RandomDateGenerator.getRandomDate()));
	}

	@GetMapping("/firstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName")String firstName){
		Optional<List<Customer>> customerList = customerService.findByFirstName(firstName);
		if(customerList.isPresent()) {
			return customerList.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/lastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable("lastName")String lastName){
		Optional<List<Customer>> customerList = customerService.findByLastName(lastName);
		if(customerList.isPresent()) {
			return customerList.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/firstName/{firstName}/lastName/{lastName}")
	public List<Customer> getCustomerByFirstNameAndLastName(@PathVariable("firstName")String firstName,@PathVariable("lastName")String lastName,@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("sortOrder") String sortOrder){		
		Sort sort = new Sort(Sort.Direction.valueOf(sortOrder.toUpperCase()), "dateOfBirth"); // results will be sorted by the date of birth in the order specified in the request.
		Pageable pageable = PageRequest.of(page, size, sort);
		Optional<List<Customer>> customerList = customerService.findByFirstNameAndLastName(firstName, lastName, pageable);
		if(customerList.isPresent()) {
			return customerList.get();
		}
		else {
			return null;
		}
	}
	
}
