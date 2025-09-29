package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.HomeAddressDto;
import com.machi.tech.customer_service.model.HomeAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HomeAddressMapper {
    HomeAddress mapToEntity(HomeAddressDto homeAddressDto);
    HomeAddressDto mapToDto(HomeAddress homeAddress);
}
