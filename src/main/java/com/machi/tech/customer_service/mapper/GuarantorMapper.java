package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.GuarantorDto;
import com.machi.tech.customer_service.model.Guarantor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuarantorMapper {
    Guarantor mapToEntity(GuarantorDto guarantorDto);
    GuarantorDto mapToDto(Guarantor guarantor);
}
