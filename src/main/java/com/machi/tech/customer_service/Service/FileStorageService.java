package com.machi.tech.customer_service.Service;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileStorageService {
    String saveFile(MultipartFile file, String clientId, String documentType) throws IOException;
    Resource loadFile(String fileName) throws MalformedURLException;

    void saveKycDocuments(
            String clientId,
            MultipartFile passportSize,
            MultipartFile identificationCard,
            MultipartFile introductionLetter,
            MultipartFile utilityBill
    );

    String saveFile(MultipartFile file, String namePrefix);
}
