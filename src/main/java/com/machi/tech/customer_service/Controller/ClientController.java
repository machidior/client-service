package com.machi.tech.customer_service.Controller;

import com.machi.tech.customer_service.Repository.ClientRepository;
import com.machi.tech.customer_service.Service.ClientService;
import com.machi.tech.customer_service.Service.FileStorageService;
import com.machi.tech.customer_service.dto.*;
import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.model.NextOfKin;
import com.machi.tech.customer_service.model.SpouseDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final FileStorageService fileStorageService;

    @PostMapping("/create/personal-details")
    public ResponseEntity<ClientResponse> createPersonalDetails(@RequestBody PersonalDetails personalDetails){
        return ResponseEntity.ok(clientService.createClient(personalDetails));
    }

    @PostMapping(value = "/create/save-kyc-document/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createKYCDocument(
            @PathVariable("id") String id,
            @RequestParam("passportSize") MultipartFile passportSize,
            @RequestParam("identificationCard") MultipartFile identificationCard,
            @RequestParam("introductionLetter") MultipartFile introductionLetter,
            @RequestParam("utilityBill") MultipartFile utilityBill
    ){

        fileStorageService.saveKycDocuments(
                id,
                passportSize,
                identificationCard,
                introductionLetter,
                utilityBill
        );

        return ResponseEntity.ok().body("KYC documents saved successfully!");
    }

    @PostMapping("/create/next-of-kin/{id}")
    public ResponseEntity<ClientResponse> saveNextOfKin(@PathVariable("id") String id, @RequestBody NextOfKin nextOfKin){
        return ResponseEntity.ok(clientService.saveNextOfKin(id,nextOfKin));
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @PostMapping(
            value = "/create/spouse-details/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ClientResponse> saveSpouseDetails(
            @PathVariable("id") String id,
            @RequestPart("marriageCertificate") MultipartFile marriageCertificate,
            @RequestPart("consentDocument") MultipartFile consentDocument,
            @RequestPart("spouseDetails") SpouseDetails spouseDetails
    ) {
        ClientResponse response = clientService.saveSpouseDetails(
                id, marriageCertificate, consentDocument, spouseDetails
        );
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(
            @PathVariable String id,
            @Valid @RequestBody ClientUpdateRequest request) {
        return ResponseEntity.ok(clientService.updateClient(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable String id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping
    public ResponseEntity<?> getClients(Pageable pageable) {
        return ResponseEntity.ok(clientService.getClients(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/kyc")
    public ResponseEntity<String> uploadKycFile(
            @PathVariable String id,
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file) throws IOException {   // <-- declare here

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        String fileName = fileStorageService.saveFile(file, id, documentType);

        return ResponseEntity.ok("File uploaded: " + fileName);
    }


}
