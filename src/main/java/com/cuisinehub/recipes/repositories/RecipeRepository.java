package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    
}
