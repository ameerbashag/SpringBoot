package com.eai.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eai.integration.bo.Customer;
import com.eai.integration.repository.CustomerRepository;

/**
 * @author Ameer
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value = "/customer/{customerID}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Customer getCustomer(@PathVariable Integer customerID) {
		Customer customer = customerRepository.findByCustomerID(customerID);
        return customer;
    }
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String createCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		String message = "Customer Created successfully";
        return message;
    }
}
