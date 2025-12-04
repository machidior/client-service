package com.machi.tech.customer_service.Service;

import com.machi.tech.customer_service.dto.ClientResponse;
import com.machi.tech.customer_service.dto.ClientUpdateRequest;
import com.machi.tech.customer_service.dto.PersonalDetails;
import com.machi.tech.customer_service.model.NextOfKin;
import com.machi.tech.customer_service.model.SpouseDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ClientService {

    ClientResponse createClient(PersonalDetails request);

    ClientResponse saveNextOfKin(String id, NextOfKin nextOfKin);


    ClientResponse saveSpouseDetails(
            String clientId,
            MultipartFile marriageCertificate,
            MultipartFile consentDocument,
            SpouseDetails spouseDetails
    );

    ClientResponse updateClient(String id, ClientUpdateRequest request);

    ClientResponse getClientById(String id);

    Page<ClientResponse> getClients(Pageable pageable);

    void deleteClient(String id);
}
