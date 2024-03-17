package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    
}
