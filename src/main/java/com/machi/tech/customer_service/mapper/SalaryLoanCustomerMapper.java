package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.SalaryLoanCustomerDto;
import com.machi.tech.customer_service.model.SalaryLoanCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalaryLoanCustomerMapper {
    SalaryLoanCustomer mapToEntity(SalaryLoanCustomerDto salaryLoanCustomerDto);
    SalaryLoanCustomerDto mapToDto(SalaryLoanCustomer salaryLoanCustomer);
}
