package com.machi.tech.customer_service.model;

import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "client-id-generator")
    @GenericGenerator(name = "client-id-generator", strategy = "com.machi.tech.customer_service.util.CustomClientIdGenerator")
    private String id;
    @Embedded
    private Name fullName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "nida_number")
    private Integer nidaNumber;
    private Gender gender;
    private MaritalStatus maritalStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private HomeAddress homeAddress;
    private String citizenship;
    @OneToOne(cascade = CascadeType.ALL)
    private ResidentialAddress residentialAddress;
    private EducationLevel educationLevel;
    private String email;
    private Long phoneNumber;
    private String passportSizePhoto;
}
