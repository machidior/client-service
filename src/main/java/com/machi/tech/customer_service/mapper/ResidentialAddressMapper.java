package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.ResidentialAddressDTO;
import com.machi.tech.customer_service.model.ResidentialAddress;

public class ResidentialAddressMapper {
    public static ResidentialAddressDTO toDto(ResidentialAddress entity) {
        if (entity == null) return null;

        ResidentialAddressDTO dto = new ResidentialAddressDTO();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setDistrict(entity.getDistrict());
        dto.setRegion(entity.getRegion());
        dto.setFamousName(entity.getFamousName());
        dto.setWard(entity.getWard());
        dto.setHouseNumber(entity.getHouseNumber());

        return dto;
    }

    public static ResidentialAddress toEntity(ResidentialAddressDTO dto) {
        if (dto == null) return null;

        ResidentialAddress entity = new ResidentialAddress();
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setDistrict(dto.getDistrict());
        entity.setRegion(dto.getRegion());
        entity.setFamousName(dto.getFamousName());
        entity.setWard(dto.getWard());
        entity.setHouseNumber(dto.getHouseNumber());

        return entity;
    }

}
