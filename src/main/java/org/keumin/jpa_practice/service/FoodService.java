package org.keumin.jpa_practice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.keumin.jpa_practice.controller.FoodDto;
import org.keumin.jpa_practice.domain.Food;
import org.keumin.jpa_practice.domain.FoodPrimaryKey;
import org.keumin.jpa_practice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public List<Food> getAllFood(String name) {
        return foodRepository.findAllByPk_Company(name);
    }

    public Food createFood(FoodDto.Post post) {
        Food food = new Food();
        food.setPk(new FoodPrimaryKey(post.getCompany(), post.getName()));
        return foodRepository.save(food);
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }
}
