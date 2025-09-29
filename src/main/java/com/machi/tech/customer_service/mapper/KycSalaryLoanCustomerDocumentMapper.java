package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.KycSalaryLoanCustomerDocumentDto;
import com.machi.tech.customer_service.model.KycSalaryLoanCustomerDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KycSalaryLoanCustomerDocumentMapper {
    KycSalaryLoanCustomerDocument mapToEntity(KycSalaryLoanCustomerDocumentDto kycSalaryLoanCustomerDocumentDto);
    KycSalaryLoanCustomerDocumentDto mapToDto(KycSalaryLoanCustomerDocument kycSalaryLoanCustomerDocument);
}
