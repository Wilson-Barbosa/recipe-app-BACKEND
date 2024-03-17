package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    
}
