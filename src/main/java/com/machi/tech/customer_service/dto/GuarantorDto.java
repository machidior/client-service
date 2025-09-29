package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.model.Guarantor;
import com.machi.tech.customer_service.model.ResidentialAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuarantorDto {
    private Long id;
    @Embedded
    private NameDto fullName;
    private String passportSize;
    private String consentForm; //fomu ya kukubali kuwa mdhamini.
    private Long nidaNumber;
    private String phoneNumber;
    private List<String> colateralDetails;
    private ResidentialAddressDto residentialAddress;
    private Boolean approved;

}
