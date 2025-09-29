package com.machi.tech.customer_service.repository;

import com.machi.tech.customer_service.model.BusinessLoanCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessLoanCustomerRepository extends JpaRepository<BusinessLoanCustomer, String> {
}
