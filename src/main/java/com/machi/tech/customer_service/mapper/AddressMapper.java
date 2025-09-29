package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.AddressDto;
import com.machi.tech.customer_service.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address mapToEntity(AddressDto addressDto);
    AddressDto mapToDto(Address address);

}
