package com.machi.tech.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class KycBusinessLoanCustomerDocumentDto  extends DocumentDto {
    private Long id;
    private String type;
    private BusinessLoanCustomerDto customer;
}
