package org.keumin.jpa_practice.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FoodDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private Long id;
        private String name;
        private String company;
        private String description;
        private Double price;
    }
}
