package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.CollateralDto;
import com.machi.tech.customer_service.model.Collateral;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CollateralMapper {
    Collateral mapToEntity(CollateralDto collateralDto);
    CollateralDto mapToDto(Collateral collateral);
}
