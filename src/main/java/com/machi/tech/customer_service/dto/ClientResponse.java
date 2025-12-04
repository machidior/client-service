package com.machi.tech.customer_service.dto;

import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import com.machi.tech.customer_service.enums.Status;
import com.machi.tech.customer_service.model.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClientResponse {

    private String id;
    private Name fullName;
    private LocalDate dateOfBirth;
    private Integer age;
    private String nidaNumber;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private HomeAddress homeAddress;
    private ResidentialAddress residentialAddress;
    private EducationLevel educationLevel;
    private String email;
    private Long phoneNumber;
    private Status status;
    private LocalDateTime dateOfRegistration;

    private String passportSizeUrl;
    private String introductionLetterUrl;
    private String identificationCardUrl;
    private String utilityBillUrl;

    private NextOfKin nextOfKin;
    private SpouseDetails spouseDetails;
}
