package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.RecipeTag;

@Repository
public interface RecipeTagRepository extends JpaRepository<RecipeTag, Integer> {
    
}
