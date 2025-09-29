package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.LoanDetailsDto;
import com.machi.tech.customer_service.model.LoanDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanDetailsMapper {
    LoanDetails mapToEntity(LoanDetailsDto loanDetailsDto);
    LoanDetailsDto mapToDto(LoanDetails loanDetails);
}
