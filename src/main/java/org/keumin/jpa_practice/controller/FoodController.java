package org.keumin.jpa_practice.controller;

import lombok.AllArgsConstructor;
import org.keumin.jpa_practice.domain.Food;
import org.keumin.jpa_practice.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods(@RequestParam String name) {
        return foodService.getAllFood(name);
    }

    @PostMapping
    public Food addFood(@RequestBody FoodDto.Post post) {
        return foodService.createFood(post);
    }

    @PutMapping
    public Food updateFood(@RequestBody Food food) {
        return foodService.updateFood(food);
    }
}
