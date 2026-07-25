package com.masjedy.Application.Dtos;

import lombok.Data;

public class MosqueDto {

    @Data
    public static class CreateRequest {
        private String name;
        private String location;
        private String image;
    }
}
