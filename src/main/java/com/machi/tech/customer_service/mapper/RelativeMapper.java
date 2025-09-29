package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.RelativeDto;
import com.machi.tech.customer_service.model.Relative;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelativeMapper {
    Relative mapToEntity(RelativeDto relativeDto);
    RelativeDto mapToDto(Relative relative);
}
