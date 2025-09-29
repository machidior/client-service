package com.machi.tech.customer_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal requiredLoan;
    private String loanDescription;
    private Long repaymentMonths;
    private BigDecimal returnAmountPerMonth;
    private Long totalMfiCurrentBorrowed;
    private BigDecimal totalCurrentLoan;
}
