package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import com.machi.tech.customer_service.model.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonalDetails {

    @NotNull
    private Name fullName;
    @NotNull
    private LocalDate dateOfBirth;
    private String nidaNumber;
    @NotNull
    private Gender gender;
    @NotNull
    private MaritalStatus maritalStatus;
    private HomeAddress homeAddress;
    private String citizenship;
    private ResidentialAddress residentialAddress;
    @NotNull
    private EducationLevel educationLevel;
    private String email;
    @NotNull
    private Long phoneNumber;




}
