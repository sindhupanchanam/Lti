package com.lti.customer_producer.controllers;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.customer_producer.model.Customer;
import com.lti.customer_producer.repository.CustomerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/customer-producer")
public class TestController {
	
	@Autowired
	private CustomerRepository cr;
	
	
	@CircuitBreaker(fallbackMethod = "getDataFallBack", name = "producer")
	@GetMapping(value = "/customer/{id}")
	public Customer getCustomres(@PathVariable("id") Integer id){
	Customer customer=cr.findById(id).get();
		//added just for circuit breaker check
		if(customer.getName()== null) {
			throw new RuntimeException();
		}else {
			return customer;
		}
	}
            
	 @GetMapping("/findByid/{id}")
		public ResponseEntity<?>getByid(@PathVariable("id") Integer id){
			Optional<Customer> customer =  cr.findById(id);
			if(customer!=null) {
				return new ResponseEntity<>(customer,HttpStatus.FOUND);
			}else {
				return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);	
			}
			
		}
	 

	 
	 
	 @PostMapping("/save")
		public ResponseEntity<?>save(@RequestBody Customer c){
			
			Customer customer =  cr.save(c);
			if(customer!=null) {
				return new ResponseEntity<>(customer,HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("Product Not Found",HttpStatus.FAILED_DEPENDENCY);	
			}
		}
	 
	 public String getDataFallBack(Throwable hystrixCommand) {
	        return "Fall Back Called in Coustomer Consumer";
	    }

	

}
