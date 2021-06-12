package com.javasampleapproach.dynamodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.javasampleapproach.dynamodb.model.Customer;
import com.javasampleapproach.dynamodb.repo.CustomerRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RequestMapping("/api")
public class WebController {

	@Autowired
	CustomerRepository repository;

	@PostMapping("/delete")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}

	@PostMapping("/AddCustomerData")
	public ResponseEntity<Object> AddCustomer(@RequestBody Customer customer) {
		Customer CreateStudent = repository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(CreateStudent.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/Findall")
	public List<Customer> retrieveAllCustomers() {
		return (List<Customer>) repository.findAll();
	}

	@GetMapping("/findbyid")
	public Customer retrieveCustomer(String id) {
		Optional<Customer> customer = repository.findById(id);
		return customer.get();
	}

	@GetMapping("/findbylastname")
	public Customer fetchcustomerbylastname(String lastname) {
		List<Customer> customer = repository.findByLastName(lastname);
		return customer.get(toString(lastname));
	}

	private int toString(String lastname) {
		return 0;
	}
}
