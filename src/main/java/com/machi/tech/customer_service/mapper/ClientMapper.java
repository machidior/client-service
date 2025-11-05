package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.ClientDTO;
import com.machi.tech.customer_service.enums.EducationLevel;
import com.machi.tech.customer_service.enums.Gender;
import com.machi.tech.customer_service.enums.MaritalStatus;
import com.machi.tech.customer_service.enums.Status;
import com.machi.tech.customer_service.model.Client;

public class ClientMapper {
    public static Client toEntity(ClientDTO dto) {
        if (dto == null) return null;

        Client client = new Client();
        client.setId(dto.getId());
        client.setFullName(dto.getFullName());
        client.setDateOfBirth(dto.getDateOfBirth());
        client.setNidaNumber(dto.getNidaNumber());

        if (dto.getGender() != null) {
            client.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        }

        if (dto.getMaritalStatus() != null) {
            client.setMaritalStatus(MaritalStatus.valueOf(dto.getMaritalStatus().toUpperCase()));
        }

        client.setHomeAddress(HomeAddressMapper.toEntity(dto.getHomeAddress()));
        client.setCitizenship(dto.getCitizenship());
        client.setResidentialAddress(ResidentialAddressMapper.toEntity(dto.getResidentialAddress()));

        if (dto.getEducationLevel() != null) {
            client.setEducationLevel(EducationLevel.valueOf(dto.getEducationLevel().toUpperCase()));
        }

        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setPassportSizePhoto(dto.getPassportSizePhoto());
        client.setLoanOfficerId(dto.getLoanOfficerId());

        if (dto.getStatus() != null) {
            client.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        }

        return client;
    }


    public static ClientDTO toDto(Client client) {
        if (client == null) return null;

        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setFullName(client.getFullName());
        dto.setDateOfBirth(client.getDateOfBirth());
        dto.setNidaNumber(client.getNidaNumber());
        dto.setGender(client.getGender() != null ? client.getGender().name() : null);
        dto.setMaritalStatus(client.getMaritalStatus() != null ? client.getMaritalStatus().name() : null);
        dto.setHomeAddress(HomeAddressMapper.toDto(client.getHomeAddress()));
        dto.setCitizenship(client.getCitizenship());
        dto.setResidentialAddress(ResidentialAddressMapper.toDto(client.getResidentialAddress()));
        dto.setEducationLevel(client.getEducationLevel() != null ? client.getEducationLevel().name() : null);
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setPassportSizePhoto(client.getPassportSizePhoto());
        dto.setLoanOfficerId(client.getLoanOfficerId());
        dto.setStatus(client.getStatus() != null ? client.getStatus().name() : null);

        return dto;
    }

}
