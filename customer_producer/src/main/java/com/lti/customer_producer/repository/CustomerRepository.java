package com.lti.customer_producer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.customer_producer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	 

}
