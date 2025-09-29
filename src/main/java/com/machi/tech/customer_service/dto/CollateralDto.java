package com.machi.tech.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CollateralDto {
    private Long id;
//    private IndividualCustomerDto customer;
    private String name;
    private byte[] photo;
    private String description;
}
