package com.machi.tech.customer_service.controller;

import com.machi.tech.customer_service.dto.BusinessLoanCustomerDto;
import com.machi.tech.customer_service.service.BusinessLoanCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business-loan-customers")
@RequiredArgsConstructor
public class BusinessLoanCustomerController {
    private final BusinessLoanCustomerService businessLoanCustomerService;

    @PostMapping("/save")
    public ResponseEntity<?> saveBusinessLoanCustomer(@RequestBody BusinessLoanCustomerDto customerDto){
        businessLoanCustomerService.saveBusinessLoanCustomer(customerDto);
        return new ResponseEntity<>("Customer saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<BusinessLoanCustomerDto> getBusinessLoanCustomerById(@PathVariable("id") String id){
        return ResponseEntity.ok(businessLoanCustomerService.getBusinessLoanCustomerById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusinessLoanCustomerDto>> getAllBusinessLoanCustomers(){
        return ResponseEntity.ok(businessLoanCustomerService.getAllBusinessLoanCustomers());
    }

    @DeleteMapping("/delete-customer-by-id")
    public ResponseEntity<?> deleteBusinessLoanCustomerById(@RequestParam String id){
        businessLoanCustomerService.deleteBusinessLoanCustomerById(id);
        return ResponseEntity.ok("Customer deleted successfully!");
    }

    public ResponseEntity<?> deleteMe(){
        return ResponseEntity.ok("Hello World!");
    }
}
