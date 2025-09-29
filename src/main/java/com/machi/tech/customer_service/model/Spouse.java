package com.machi.tech.customer_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Name fullName;
    @Column(unique = true)
    private Long nidaNumber;
    @Lob
    @Column(name = "marriage_certificate", columnDefinition = "LONGBLOB")
    private byte[] marriageCertificate;
    @Lob
    @Column(name = "consent_document", columnDefinition = "LONGBLOB")
    private byte[] consentDocument;

}
