package com.machi.tech.customer_service.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class DocumentDto {
    private byte[] file;
    private Boolean verified;
    private LocalDate issueDate;
    private LocalDate expiryDate;
}
