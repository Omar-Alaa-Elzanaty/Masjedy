package com.masjedy.Application.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.masjedy.Application.Dtos.MosqueDto;
import com.masjedy.Domain.Models.Mosque;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MosqueMapper {
    Mosque toEntity(MosqueDto.CreateRequest request);
}
