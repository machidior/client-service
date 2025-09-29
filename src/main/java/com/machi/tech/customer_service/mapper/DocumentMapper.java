package com.machi.tech.customer_service.mapper;

import com.machi.tech.customer_service.dto.DocumentDto;
import com.machi.tech.customer_service.model.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    Document mapToEntity(DocumentDto documentDto);
    DocumentDto mapToDto(Document document);
}
