package com.javasampleapproach.dynamodb.repo;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.dynamodb.model.Customer;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

	List<Customer> findByLastName(String lastName);

    Optional<Customer> findById(String id);

}
