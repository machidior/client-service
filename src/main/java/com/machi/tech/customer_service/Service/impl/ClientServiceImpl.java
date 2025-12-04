package com.machi.tech.customer_service.Service.impl;

import com.machi.tech.customer_service.Repository.ClientRepository;
import com.machi.tech.customer_service.Service.ClientService;
import com.machi.tech.customer_service.Service.FileStorageService;
import com.machi.tech.customer_service.dto.ClientResponse;
import com.machi.tech.customer_service.dto.ClientUpdateRequest;
import com.machi.tech.customer_service.dto.PersonalDetails;
import com.machi.tech.customer_service.enums.Status;
import com.machi.tech.customer_service.exceptions.DuplicateResourceException;
import com.machi.tech.customer_service.exceptions.ResourceNotFoundException;
import com.machi.tech.customer_service.mapper.ClientMapper;
import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.model.NextOfKin;
import com.machi.tech.customer_service.model.SpouseDetails;
import com.machi.tech.customer_service.util.ClientIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientIdGenerator clientIdGenerator;
    private final FileStorageService fileStorageService;

    public ClientResponse createClient(PersonalDetails personalDetails) {

        if (clientRepository.existsByNidaNumber(personalDetails.getNidaNumber()))
            throw new DuplicateResourceException("NIDA number already exists");

        validateAge(personalDetails.getDateOfBirth());

        Client client = clientMapper.toEntity(personalDetails);
        client.setId(clientIdGenerator.generateClientId());
        client.setAge(calculateAge(client.getDateOfBirth()));
        client.setStatus(Status.DRAFTED);
        client.setDateOfRegistration(java.time.LocalDateTime.now());

        clientRepository.save(client);
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponse saveNextOfKin(String id, NextOfKin nextOfKin){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with given id is not found!"));
        nextOfKin.setClient(client);
        client.setNextOfKin(nextOfKin);
        return clientMapper.toResponse(clientRepository.save(client));
    }

    @Override
    public ClientResponse saveSpouseDetails(
            String clientId,
            MultipartFile marriageCertificate,
            MultipartFile consentDocument,
            SpouseDetails spouseDetails
    ) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        String certificateUrl = fileStorageService.saveFile(marriageCertificate, "marriage-certificates");
        String consentUrl = fileStorageService.saveFile(consentDocument, "consent-documents");

        spouseDetails.setMarriageCertificateUrl(certificateUrl);
        spouseDetails.setConsentDocumentUrl(consentUrl);

        client.setSpouseDetails(spouseDetails);


        return clientMapper.toResponse(clientRepository.save(client));
    }


    public int calculateAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }


    public ClientResponse updateClient(String id, ClientUpdateRequest request) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        if (request.getDateOfBirth() != null)
            validateAge(request.getDateOfBirth());

        clientMapper.updateClientFromDto(request, client);

        clientRepository.save(client);
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponse getClientById(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return clientMapper.toResponse(client);
    }

    @Override
    public Page<ClientResponse> getClients(Pageable pageable) {
        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(clientMapper::toResponse);
    }

    @Override
    public void deleteClient(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        clientRepository.delete(client);
    }

    private void validateAge(LocalDate dob) {
        if (dob.plusYears(18).isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Client must be at least 18 years old");
    }
}
