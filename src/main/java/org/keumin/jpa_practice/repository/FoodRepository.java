package org.keumin.jpa_practice.repository;

import org.keumin.jpa_practice.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
