package com.machi.tech.customer_service.controller;

import com.machi.tech.customer_service.dto.SalaryLoanCustomerDto;
import com.machi.tech.customer_service.service.SalaryLoanCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary-loan-customer")
@RequiredArgsConstructor
public class SalaryLoanCustomerController {
    private final SalaryLoanCustomerService salaryLoanCustomerService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSalaryLoanCustomer(@RequestBody SalaryLoanCustomerDto salaryLoanCustomerDto){
        salaryLoanCustomerService.saveSalaryLoanCustomer(salaryLoanCustomerDto);
        return new ResponseEntity<>("Customer saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<SalaryLoanCustomerDto> getSalaryLoanCustomerById(@PathVariable("id") String id){
        return ResponseEntity.ok(salaryLoanCustomerService.getSalaryLoanCustomerById(id));
    }

    @GetMapping("/all-customers")
    public ResponseEntity<List<SalaryLoanCustomerDto>> getAllSalaryLoanCustomers(){
        return ResponseEntity.ok(salaryLoanCustomerService.getAllSalaryLoanCustomers());
    }

    @DeleteMapping("/delete-customer-by-id")
    public ResponseEntity<?> deleteSalaryLoanCustomerById(@RequestParam String id){
        salaryLoanCustomerService.deleteSalaryLoanCustomerById(id);
        return ResponseEntity.ok("Customer deleted successfully!");
    }
}
