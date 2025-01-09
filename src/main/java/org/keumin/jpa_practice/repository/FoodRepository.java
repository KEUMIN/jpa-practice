package org.keumin.jpa_practice.repository;

import org.keumin.jpa_practice.domain.Food;
import org.keumin.jpa_practice.domain.FoodPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, FoodPrimaryKey> {
    List<Food> findAllByPk_Company(String company);
}
