package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.ResidentialAddressDto;
import com.machi.tech.customer_service.model.ResidentialAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResidentialAddressMapper {
    ResidentialAddress mapToEntity(ResidentialAddressDto residentialAddressDto);
    ResidentialAddressDto mapToDto(ResidentialAddress residentialAddress);
}
