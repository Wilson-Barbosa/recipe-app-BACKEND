package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.RecipeTag;

public interface RecipeTagRepository extends JpaRepository<RecipeTag, Integer> {
    
}
