package com.machi.tech.customer_service.Service;

import com.machi.tech.customer_service.Repository.ClientRepository;
import com.machi.tech.customer_service.dto.ClientDTO;
import com.machi.tech.customer_service.mapper.ClientMapper;
import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.util.ClientIdGenerator;
import com.machi.tech.customer_service.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientIdGenerator clientIdGenerator;


    public Client createClient(ClientDTO dto) {
        Client client = ClientMapper.toEntity(dto);
        client.setId(clientIdGenerator.generateClientId());

        client.setStatus(Status.NEW);


        return repository.save(client);
    }

    public ClientDTO getClient(String clientId) {
        Client client = repository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDto(client);
    }

    public ClientDTO updateClient(String clientId, ClientDTO dto) {
        Client existing = repository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client not found"));

        Client updated = ClientMapper.toEntity(dto);
        updated.setId(existing.getId());
        if (updated.getStatus() == null) {
            updated.setStatus(existing.getStatus());
        }
        return ClientMapper.toDto(repository.save(updated));
    }

    public void deleteClient(String clientId) {
        repository.deleteById(clientId);
    }

    public Page<ClientDTO> listClients(Pageable pageable) {
        Page<Client> page = repository.findAll(pageable);
        return page.map(ClientMapper::toDto);
    }

    public ClientDTO findByNida(String nida) {
        Optional<Client> c = repository.findByNidaNumber(nida);
        return c.map(ClientMapper::toDto).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<ClientDTO> findByStatus(Status status) {
        return repository.findByStatus(status).stream().map(ClientMapper::toDto).collect(Collectors.toList());
    }

    public List<ClientDTO> findByLoanOfficer(String loanOfficerId) {
        return repository.findByLoanOfficerId(loanOfficerId).stream().map(ClientMapper::toDto).collect(Collectors.toList());
    }

    public ClientDTO assignLoanOfficer(String clientId, String loanOfficerId) {
        Client client = repository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setLoanOfficerId(loanOfficerId);
        return ClientMapper.toDto(repository.save(client));
    }

    public ClientDTO changeStatus(String clientId, Status status) {
        Client client = repository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setStatus(status);
        return ClientMapper.toDto(repository.save(client));
    }


}
