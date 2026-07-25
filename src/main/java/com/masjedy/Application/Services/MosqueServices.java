package com.masjedy.Application.Services;

import org.springframework.stereotype.Service;

import com.masjedy.Application.Dtos.BaseResponse;
import com.masjedy.Application.Dtos.MosqueDto;
import com.masjedy.Application.Mapper.MosqueMapper;
import com.masjedy.Domain.Models.Mosque;
import com.masjedy.Infrastructure.Presistance.MosqueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MosqueServices {
    private final MosqueRepository mosqueRepo;
    private final MosqueMapper mosqueMapper;

    public BaseResponse CreateMosque(MosqueDto.CreateRequest request) {
        if (mosqueRepo.existsByName(request.getName())) {
            return BaseResponse.Fail("Mosque with same name found.");
        }

        Mosque mosque = mosqueMapper.toEntity(request);

        mosqueRepo.save(mosque);

        return BaseResponse.Success(mosque.getId());
    }
}
