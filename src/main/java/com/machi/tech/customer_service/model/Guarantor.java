package com.machi.tech.customer_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Guarantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name fullName;
    private String passportSize;
    private String consentForm; //fomu ya kukubali kuwa mdhamini.
    @Column(unique = true)
    private Long nidaNumber;
    private String phoneNumber;
    private List<String> collaterals;
    @OneToOne(cascade = CascadeType.ALL)
    private ResidentialAddress residentialAddress;
    private Boolean approved;

}
