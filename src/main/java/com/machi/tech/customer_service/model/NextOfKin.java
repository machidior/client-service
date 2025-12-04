package com.machi.tech.customer_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.machi.tech.customer_service.enums.Relationship;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "next_of_kin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NextOfKin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    @JsonIgnore
    private Client client;
    @Embedded
    private Name fullName;
    private Integer phoneNumber;
    @Enumerated(EnumType.STRING)
    private Relationship relationship;
    @OneToOne(cascade = CascadeType.ALL)
    private RelativeResidentialAddress relativeResidentialAddress;

}
