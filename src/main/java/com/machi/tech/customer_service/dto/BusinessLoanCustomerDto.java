package com.machi.tech.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessLoanCustomerDto {
    private String id;
    private NameDto fullName;
    private LocalDate dateOfBirth;
    private Long nidaNumber;
    private String gender;
    private String maritalStatus;
    private HomeAddressDto homeAddress;
    private String citizenship;
    private ResidentialAddressDto residentialAddress;
    private String status;
    private BigDecimal netCurrentIncome;
    private LocalDate dateOfRegistration;
    private String educationLevel;
    private String email;
    private GuarantorDto guarantor;
    private SpouseDto spouse;
    private List<RelativeDto> relatives;
    private List<CollateralDto> collaterals;
    private LoanDetailsDto loanDetails;
    private Long tin;
    private List<KycBusinessLoanCustomerDocumentDto> documents;
    private List<BusinessDetailsDto> businessDetails;
}
