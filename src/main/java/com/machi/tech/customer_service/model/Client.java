package com.machi.tech.customer_service.model;

import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import com.machi.tech.customer_service.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private String id;
    @Embedded
    private Name fullName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "nida_number", unique = true, nullable = false)
    private String nidaNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private HomeAddress homeAddress;
    private String citizenship;
    @OneToOne(cascade = CascadeType.ALL)
    private ResidentialAddress residentialAddress;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    private String email;
    private Long phoneNumber;
    private String passportSizePhoto;
    private String loanOfficerId;

    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    @Column(name = "date_of_registration", updatable = false)
    private LocalDateTime dateOfRegistration;
}
