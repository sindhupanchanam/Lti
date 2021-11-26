package com.lti.customer_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProducerApplication.class, args);
	}

}
