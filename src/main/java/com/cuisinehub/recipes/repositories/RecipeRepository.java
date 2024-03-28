package com.cuisinehub.recipes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    // Searches a recipe that matches the string EXACTLY
    public Recipe findByTitleIgnoreCase(String title);

    // Searches for a recipe CONTAINING a keyword
    public List<Recipe> findAllByTitleContainingIgnoreCase(String keyword);

}
