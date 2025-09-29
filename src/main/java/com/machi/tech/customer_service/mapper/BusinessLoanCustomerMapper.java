package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.BusinessLoanCustomerDto;
import com.machi.tech.customer_service.model.BusinessLoanCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessLoanCustomerMapper {
    public BusinessLoanCustomerDto mapToDto(BusinessLoanCustomer businessLoanCustomer);
    public BusinessLoanCustomer mapToEntity(BusinessLoanCustomerDto businessLoanCustomerDto);
}
