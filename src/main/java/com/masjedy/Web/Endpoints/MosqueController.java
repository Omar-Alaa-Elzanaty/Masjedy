package com.masjedy.Web.Endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masjedy.Application.Dtos.BaseResponse;
import com.masjedy.Application.Dtos.MosqueDto;
import com.masjedy.Application.Services.MosqueServices;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/mosques")
@RequiredArgsConstructor
public class MosqueController {
    private final MosqueServices mosqueServices;

    @PostMapping()
    public ResponseEntity<BaseResponse> Create(@RequestBody  MosqueDto.CreateRequest request) {
        
        return ResponseEntity.ok(mosqueServices.CreateMosque(request));
    }
    
}
