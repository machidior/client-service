package com.machi.tech.customer_service;

import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.model.BusinessLoanCustomer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
