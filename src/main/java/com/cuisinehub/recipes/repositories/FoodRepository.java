package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    
}
