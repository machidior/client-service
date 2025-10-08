package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.HomeAddressDTO;
import com.machi.tech.customer_service.model.HomeAddress;

public class HomeAddressMapper {
    public static HomeAddressDTO toDto(HomeAddress entity) {
        if (entity == null) return null;

        HomeAddressDTO dto = new HomeAddressDTO();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setDistrict(entity.getDistrict());
        dto.setRegion(entity.getRegion());
        dto.setWard(entity.getWard());

        return dto;
    }

    public static HomeAddress toEntity(HomeAddressDTO dto) {
        if (dto == null) return null;

        HomeAddress entity = new HomeAddress();
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setDistrict(dto.getDistrict());
        entity.setRegion(dto.getRegion());
        entity.setWard(dto.getWard());

        return entity;
    }

}
