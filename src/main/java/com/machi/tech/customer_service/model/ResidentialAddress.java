package com.machi.tech.customer_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResidentialAddress extends Address{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long houseNumber;
    private String famousName;
}
