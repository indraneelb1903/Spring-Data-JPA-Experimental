package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {

	public Optional<List<Customer>> findByLastName(String lastName);
	
	public Optional<List<Customer>> findByFirstName(String firstName);
	
	public Optional<List<Customer>> findByFirstNameAndLastName(String firstName , String lastName , Pageable pageable);
}
