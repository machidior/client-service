package com.machi.tech.customer_service.service;

import com.machi.tech.customer_service.dto.BusinessLoanCustomerDto;
import com.machi.tech.customer_service.exceptions.ResourceNotFoundException;
import com.machi.tech.customer_service.mapper.BusinessLoanCustomerMapper;
import com.machi.tech.customer_service.model.BusinessLoanCustomer;
import com.machi.tech.customer_service.repository.BusinessLoanCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessLoanCustomerService {
    private final BusinessLoanCustomerRepository businessLoanCustomerRepository;
    private BusinessLoanCustomerMapper mapper;

    public void saveBusinessLoanCustomer(BusinessLoanCustomerDto customerDto){
        BusinessLoanCustomer customer = mapper.mapToEntity(customerDto);
        businessLoanCustomerRepository.save(customer);
    }

    public BusinessLoanCustomerDto getBusinessLoanCustomerById(String id){
        BusinessLoanCustomer customer = businessLoanCustomerRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Customer is not found!"));
        return mapper.mapToDto(customer);
    }

    public List<BusinessLoanCustomerDto> getAllBusinessLoanCustomers(){
        List<BusinessLoanCustomer> customers = businessLoanCustomerRepository.findAll();
        return customers.stream()
            .map(mapper::mapToDto)
            .toList();
    }

    public void deleteBusinessLoanCustomerById(String id){
        businessLoanCustomerRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Customer with given id is not found!"));
        businessLoanCustomerRepository.deleteById(id);
    }
}
