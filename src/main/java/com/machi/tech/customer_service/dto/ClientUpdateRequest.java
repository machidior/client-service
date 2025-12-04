package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import com.machi.tech.customer_service.model.HomeAddress;
import com.machi.tech.customer_service.model.Name;
import com.machi.tech.customer_service.model.ResidentialAddress;
import lombok.*;
import java.time.LocalDate;

@Data
public class ClientUpdateRequest {

    private Name fullName;

    private LocalDate dateOfBirth;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private HomeAddress homeAddress;

    private ResidentialAddress residentialAddress;

    private EducationLevel educationLevel;

    private String email;

    private Long phoneNumber;

    private String loanOfficerId;
}
