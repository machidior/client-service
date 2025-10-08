package com.machi.tech.customer_service.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.machi.tech.customer_service.Service.ClientService;
import com.machi.tech.customer_service.dto.ClientDTO;
import com.machi.tech.customer_service.mapper.ClientMapper;
import com.machi.tech.customer_service.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ClientDTO> createClient(
        @RequestPart("client") String clientJson,
        @RequestPart("passportPhoto") MultipartFile passportPhotoFile
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClientDTO clientDTO = mapper.readValue(clientJson, ClientDTO.class);
        Client savedClient = service.createClient(clientDTO, passportPhotoFile);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientMapper.toDto(savedClient));
    }


    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(service.getClient(clientId));
    }

    @GetMapping("/{clientId}/photo")
    public ResponseEntity<byte[]> getClientPhoto(@PathVariable String clientId) {
        byte[] imageBytes = service.getClientPhoto(clientId);
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imageBytes);
    }



}
