package com.cuisinehub.recipes.repositories.recipes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.recipes.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    // Searches a recipe that matches the string EXACTLY
    Recipe findByTitleIgnoreCase(String title);

    // Searches for a recipe CONTAINING a keyword
    List<Recipe> findAllByTitleContainingIgnoreCase(String keyword);

}
