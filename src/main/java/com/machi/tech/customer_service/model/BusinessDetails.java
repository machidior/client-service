package com.machi.tech.customer_service.model;

import com.machi.tech.customer_service.dto.BusinessLoanCustomerDto;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

public class BusinessDetails {
    private Long id;
    private String businessName;
    private String businessDescription;
    private String businessArea;
    @Lob
    @Column(name = "brela_certificate", columnDefinition = "LONGBLOB")
    private byte[] brelaCertificate;
    @Lob
    @Column(name = "tin_certificate", columnDefinition = "LONGBLOB")
    private byte[] tinCertificate;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private BusinessLoanCustomer customer;
}
