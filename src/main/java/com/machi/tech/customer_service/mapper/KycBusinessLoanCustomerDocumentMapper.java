package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.KycBusinessLoanCustomerDocumentDto;
import com.machi.tech.customer_service.model.KycBusinessLoanCustomerDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KycBusinessLoanCustomerDocumentMapper {
    KycBusinessLoanCustomerDocument mapToEntity(KycBusinessLoanCustomerDocumentDto kycBusinessLoanCustomerDocumentDto);
    KycBusinessLoanCustomerDocumentDto mapToDto(KycBusinessLoanCustomerDocument kycBusinessLoanCustomerDocument);
}
