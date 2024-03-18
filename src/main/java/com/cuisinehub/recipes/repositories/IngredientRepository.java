package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    
}
