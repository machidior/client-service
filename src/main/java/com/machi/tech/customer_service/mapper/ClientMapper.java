package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.ClientResponse;
import com.machi.tech.customer_service.dto.ClientUpdateRequest;
import com.machi.tech.customer_service.dto.PersonalDetails;
import com.machi.tech.customer_service.model.Client;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(PersonalDetails request);

    ClientResponse toResponse(Client client);

    List<ClientResponse> toResponseList(List<Client> clients);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClientFromDto(ClientUpdateRequest request, @MappingTarget Client client);
}
