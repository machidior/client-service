package com.machi.tech.customer_service.model;

import com.machi.tech.customer_service.enums.Relationship;
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
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
    @Embedded
    private Name fullName;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Relationship relationship;
    @OneToOne(cascade = CascadeType.ALL)
    private ResidentialAddress relativeResidentialAddress;


}
