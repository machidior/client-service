package com.machi.tech.customer_service.Service;

import com.machi.tech.customer_service.Repository.ClientRepository;
import com.machi.tech.customer_service.dto.ClientDTO;
import com.machi.tech.customer_service.mapper.ClientMapper;
import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.util.ClientIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientIdGenerator clientIdGenerator;


    public Client createClient(ClientDTO dto, MultipartFile passportPhotoFile) throws IOException {
        Client client = ClientMapper.toEntity(dto);
        client.setId(clientIdGenerator.generateClientId());

        String base64Photo = Base64.getEncoder().encodeToString(passportPhotoFile.getBytes());
        client.setPassportSizePhoto(base64Photo);

        return repository.save(client);
    }

    public ClientDTO getClient(String clientId) {
        Client client = repository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDto(client);
    }

    public byte[] getClientPhoto(String clientId) {
        Client client = repository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client not found"));
        return Base64.getDecoder().decode(client.getPassportSizePhoto());
    }


}
