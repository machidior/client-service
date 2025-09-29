package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.model.Spouse;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpouseDto {
    private Long id;
    @Embedded
    private NameDto fullName;
    private Long nidaNumber;
    private byte[] marriageCertificate;
    private byte[] consentDocument;

}
