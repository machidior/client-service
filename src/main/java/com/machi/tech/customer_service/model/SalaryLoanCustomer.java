package com.machi.tech.customer_service.model;

import com.machi.tech.customer_service.enums.CustomerStatus;
import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryLoanCustomer {
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.machi.tech.customer_service.util.CustomSlcIdGenerator")
    private String id;
    @Embedded
    private Name fullName;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private Long nidaNumber;
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
    private CustomerStatus status;
    private BigDecimal netCurrentIncome;
    @Column(name="date_of_registration")
    private LocalDate dateOfRegistration;
    @Enumerated(EnumType.STRING)
    @Column(name = "education_level")
    private EducationLevel educationLevel;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Guarantor guarantor;
    @OneToOne(cascade = CascadeType.ALL)
    private Spouse spouse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaryLoanCustomer", orphanRemoval = true)
    private List<Relative> relatives;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaryLoanCustomer", orphanRemoval = true)
    private List<Collateral> collaterals;
    @OneToOne(cascade = CascadeType.ALL)
    private LoanDetails loan;

    //unique attributes
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaryLoanCustomer", orphanRemoval = true)
    private List<KycSalaryLoanCustomerDocument> documents;


}
