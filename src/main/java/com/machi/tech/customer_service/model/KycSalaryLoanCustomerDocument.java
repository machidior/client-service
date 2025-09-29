package com.machi.tech.customer_service.model;

import com.machi.tech.customer_service.enums.SalaryDocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KycSalaryLoanCustomerDocument extends Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SalaryDocumentType type;
    @ManyToOne
    @JoinColumn(name = "salary_loan_customer_id", nullable = false)
    private SalaryLoanCustomer salaryLoanCustomer;
}
