package com.eai.integration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eai.integration.bo.Customer;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	Customer findByCustomerID(Integer customerID);

}