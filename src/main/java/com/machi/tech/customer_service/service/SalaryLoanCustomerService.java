package com.machi.tech.customer_service.service;

import com.machi.tech.customer_service.dto.SalaryLoanCustomerDto;
import com.machi.tech.customer_service.exceptions.ResourceNotFoundException;
import com.machi.tech.customer_service.mapper.SalaryLoanCustomerMapper;
import com.machi.tech.customer_service.model.SalaryLoanCustomer;
import com.machi.tech.customer_service.repository.SalaryLoanCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryLoanCustomerService {
    private final SalaryLoanCustomerRepository salaryLoanCustomerRepository;
    private SalaryLoanCustomerMapper mapper;

    public void saveSalaryLoanCustomer(SalaryLoanCustomerDto salaryLoanCustomerDto){
        salaryLoanCustomerRepository.save(mapper.mapToEntity(salaryLoanCustomerDto));
    }

    public SalaryLoanCustomerDto getSalaryLoanCustomerById(String id){
        SalaryLoanCustomer customer = salaryLoanCustomerRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Customer with given id is not found!"));
        return mapper.mapToDto(customer);
    }

    public List<SalaryLoanCustomerDto> getAllSalaryLoanCustomers(){
        return salaryLoanCustomerRepository.findAll()
            .stream()
            .map(mapper::mapToDto)
            .toList();
    }

    public void deleteSalaryLoanCustomerById(String id){
        salaryLoanCustomerRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Customer does not found!"));
        salaryLoanCustomerRepository.deleteById(id);
    }
}
