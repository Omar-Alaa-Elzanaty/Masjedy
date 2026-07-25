package com.masjedy.Application.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.masjedy.Application.Dtos.MosqueDto;
import com.masjedy.Domain.Models.Mosque;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MosqueMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "users", ignore = true)
    Mosque toEntity(MosqueDto.CreateRequest request);
}
