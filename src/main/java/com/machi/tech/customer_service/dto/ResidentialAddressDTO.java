package com.machi.tech.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResidentialAddressDTO {
    private Long id;
    private String street;
    private String district;
    private String region;
    private String famousName;
    private String ward;
    private Long houseNumber;
}
