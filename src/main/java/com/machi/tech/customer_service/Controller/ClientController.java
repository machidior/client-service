package com.machi.tech.customer_service.Controller;

import com.machi.tech.customer_service.Service.ClientService;
import com.machi.tech.customer_service.dto.ClientDTO;
import com.machi.tech.customer_service.dto.LoanOfficerAssignmentDTO;
import com.machi.tech.customer_service.dto.StatusChangeDTO;
import com.machi.tech.customer_service.mapper.ClientMapper;
import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<ClientDTO> createClient(
        @RequestBody ClientDTO clientDTO
    ) {
        Client savedClient = service.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientMapper.toDto(savedClient));
    }


    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(service.getClient(clientId));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable String clientId, @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(service.updateClient(clientId, dto));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable String clientId) {
        service.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> listClients(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.listClients(pageable));
    }

    @GetMapping("/search/nida")
    public ResponseEntity<ClientDTO> findByNida(@RequestParam String nida) {
        return ResponseEntity.ok(service.findByNida(nida));
    }

    @GetMapping("/search/status")
    public ResponseEntity<List<ClientDTO>> findByStatus(@RequestParam String status) {
        Status s = Status.valueOf(status.toUpperCase());
        return ResponseEntity.ok(service.findByStatus(s));
    }

    @GetMapping("/search/loan-officer/{loanOfficerId}")
    public ResponseEntity<List<ClientDTO>> findByLoanOfficer(@PathVariable String loanOfficerId) {
        return ResponseEntity.ok(service.findByLoanOfficer(loanOfficerId));
    }

    @PostMapping("/{clientId}/assign-loan-officer")
    public ResponseEntity<ClientDTO> assignLoanOfficer(@PathVariable String clientId, @RequestBody LoanOfficerAssignmentDTO dto) {
        return ResponseEntity.ok(service.assignLoanOfficer(clientId, dto.getLoanOfficerId()));
    }

    @PostMapping("/{clientId}/status")
    public ResponseEntity<ClientDTO> changeStatus(@PathVariable String clientId, @RequestBody StatusChangeDTO dto) {
        Status s = Status.valueOf(dto.getStatus().toUpperCase());
        return ResponseEntity.ok(service.changeStatus(clientId, s));
    }


}
