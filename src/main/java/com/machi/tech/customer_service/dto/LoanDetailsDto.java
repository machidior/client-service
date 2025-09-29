package com.machi.tech.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanDetailsDto {
    private Long id;
    private BigDecimal requiredLoan;
    private String loanDescription;
    private Long repaymentMonths;
    private BigDecimal returnAmountPerMonth;
    private Long totalMfiCurrentBorrowed;
    private BigDecimal totalCurrentLoan;
}
