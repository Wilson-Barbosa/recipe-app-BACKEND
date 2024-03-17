package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    
}
