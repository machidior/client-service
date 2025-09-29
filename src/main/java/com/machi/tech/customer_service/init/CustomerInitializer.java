package com.machi.tech.customer_service.init;

import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.model.BusinessLoanCustomer;
import com.machi.tech.customer_service.model.LoanDetails;
import com.machi.tech.customer_service.model.Name;
import com.machi.tech.customer_service.repository.BusinessLoanCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CustomerInitializer implements CommandLineRunner {
    @Autowired
    private BusinessLoanCustomerRepository repository;

    @Override
    public void run(String... args) throws
        Exception {
        BusinessLoanCustomer customer = new BusinessLoanCustomer();
        Name name = new Name();
        name.setFirstName("Almachius");
        name.setMiddleName("Kisha");
        name.setLastName("Benedicto");
        customer.setFullName(name);
        Long tin = 1264566L;

        customer.setGender(Gender.FEMALE);
        customer.setTin(tin);
        LoanDetails loan = new LoanDetails();
        loan.setLoanDescription("This is new loan");
        loan.setRequiredLoan(BigDecimal.valueOf(362763.44783));
        loan.setRepaymentMonths(3L);

        customer.setLoan(loan);
//        repository.save(customer);
        System.out.println("Customer saved successfully!");
    }
}
