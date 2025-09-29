package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.enums.Relationship;
import com.machi.tech.customer_service.model.ResidentialAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RelativeDto {
    private Long id;
    private BusinessLoanCustomerDto businessLoanCustomerDto;
    private SalaryLoanCustomerDto salaryLoanCustomerDto;
    private NameDto fullName;
    private String phoneNumber;
    private Relationship relationship;
    private ResidentialAddress relativeResidentialAddress;
}
