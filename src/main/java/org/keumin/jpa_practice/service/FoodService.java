package org.keumin.jpa_practice.service;

import jakarta.persistence.EntityNotFoundException;
import org.keumin.jpa_practice.domain.Food;
import org.keumin.jpa_practice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public Food getFoodById(long id) {
        return foodRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cannot find food with id " + id)
        );
    }

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteFoodById(long id) {
        foodRepository.deleteById(id);
    }
}
