package com.machi.tech.customer_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpouseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Name fullName;
    @Column(unique = true)
    private Long nidaNumber;
    private Integer phoneNumber;
    @Column(name = "marriage_certificate_url")
    private String marriageCertificateUrl;
    @Column(name = "consent_document_url")
    private String consentDocumentUrl;

}
