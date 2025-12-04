package com.machi.tech.customer_service.Service.impl;

import com.machi.tech.customer_service.Repository.ClientRepository;
import com.machi.tech.customer_service.Service.FileStorageService;
import com.machi.tech.customer_service.model.Client;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class LocalFileStorageService implements FileStorageService {

    @Value("${file.upload-dir}")
    private String kycStoragePath;

    private final Path fileStorageLocation;
    @Autowired
    private  ClientRepository clientRepository;

    @Autowired
    public LocalFileStorageService(@Value("${file.upload-dir}") String uploadDir) throws IOException {
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(this.fileStorageLocation);
    }

    @Override
    public String saveFile(MultipartFile file, String clientId, String documentType) throws IOException {
        String fileName = clientId + "_" + documentType + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    @Override
    public Resource loadFile(String fileName) throws MalformedURLException {
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        org.springframework.core.io.Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists()) {
            return (Resource) resource;
        } else {
            throw new RuntimeException("File not found: " + fileName);
        }
    }

    @Override
    public void saveKycDocuments(
            String clientId,
            MultipartFile passportSize,
            MultipartFile identificationCard,
            MultipartFile introductionLetter,
            MultipartFile utilityBill
    ) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        String passportUrl = saveFile(passportSize, "passport-" + clientId);
        String idCardUrl = saveFile(identificationCard, "idcard-" + clientId);
        String letterUrl = saveFile(introductionLetter, "letter-" + clientId);
        String utilityUrl = saveFile(utilityBill, "utility-" + clientId);

        client.setPassportSizeUrl(passportUrl);
        client.setIdentificationCardUrl(idCardUrl);
        client.setIntroductionLetterUrl(letterUrl);
        client.setUtilityBillUrl(utilityUrl);

        clientRepository.save(client);

    }

    @Override
    public String saveFile(MultipartFile file, String namePrefix) {

        try {
            if (file.isEmpty()) {
                return null;
            }

            // Create storage folder if not exists
            Files.createDirectories(Paths.get(kycStoragePath));

            String fileName = namePrefix + "-" + UUID.randomUUID() +
                    "." + Objects.requireNonNull(file.getOriginalFilename())
                    .split("\\.")[1];

            Path path = Paths.get(kycStoragePath + "/" + fileName);

            Files.write(path, file.getBytes());

            return "/files/kyc/" + fileName;

        } catch (Exception e) {
            throw new RuntimeException("Error saving file: " + e.getMessage());
        }
    }

}

