package com.machi.tech.customer_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Lob
    @Column(name = "file", columnDefinition = "LONGBLOB")
    private byte[] file;
    private Boolean verified;
    private LocalDate issueDate;
    private LocalDate expiryDate;
}
