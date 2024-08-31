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
    public List<Food> getAllFoods() {
        return foodService.getAllFood();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    @PutMapping
    public Food updateFood(@RequestBody Food food) {
        return foodService.updateFood(food);
    }

    @DeleteMapping
    public void deleteFoodById(@PathVariable Long id) {
        foodService.deleteFoodById(id);
    }
}
