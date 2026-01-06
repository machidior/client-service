package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import com.machi.tech.customer_service.model.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Data
public class PersonalDetails {

    @NotNull(message = "Name must be provided")
    private Name fullName;
    @NotNull(message = "please provide date of birth.")
    private LocalDate dateOfBirth;
    @Pattern(regexp = "^\\d{20}$", message = "Invalid NIDA number provided.")
    private String nidaNumber;
    @NotNull(message = "Gender is required.")
    private Gender gender;
    @NotNull(message = "Marital status must be provided.")
    private MaritalStatus maritalStatus;
    private HomeAddress homeAddress;
    @NotBlank
    private String citizenship;
    private ResidentialAddress residentialAddress;
    @NotNull
    private EducationLevel educationLevel;
    @Email(message = "Invalid email address provided.")
    private String email;
//    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number provided.")
    private Long phoneNumber;

}
