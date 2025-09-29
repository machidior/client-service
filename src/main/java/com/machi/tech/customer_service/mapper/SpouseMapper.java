package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.SpouseDto;
import com.machi.tech.customer_service.model.Spouse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpouseMapper {
    Spouse mapToEntity(SpouseDto spouseDto);
    SpouseDto mapToDto(Spouse spouse);
}
