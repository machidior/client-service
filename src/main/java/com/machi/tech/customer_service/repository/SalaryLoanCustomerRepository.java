package com.machi.tech.customer_service.repository;

import com.machi.tech.customer_service.model.SalaryLoanCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryLoanCustomerRepository extends JpaRepository<SalaryLoanCustomer, String> {
}
