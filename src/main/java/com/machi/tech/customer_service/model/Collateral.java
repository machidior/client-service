package com.machi.tech.customer_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collateral{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "business_customer_id", nullable = false)
    private BusinessLoanCustomer businessLoanCustomer;
    @ManyToOne
    @JoinColumn(name = "salary_customer_id", nullable = false)
    private SalaryLoanCustomer salaryLoanCustomer;
    private String name;
    @Lob
    @Column(name = "photo", columnDefinition = "LONGBLOB")
    private byte[] photo;
    private String description;

}
