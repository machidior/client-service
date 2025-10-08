package com.machi.tech.customer_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.machi.tech.customer_service.model.Name;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String id;
    @Embedded
    private Name fullName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String nidaNumber;
    private String gender;
    private String maritalStatus;
    private HomeAddressDTO homeAddress;
    private String citizenship;
    private ResidentialAddressDTO residentialAddress;
    private String educationLevel;
    private String email;
    private Long phoneNumber;
    private String passportSizePhoto;
}
