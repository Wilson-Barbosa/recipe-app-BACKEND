package com.cuisinehub.recipes.repositories.recipes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.recipes.RecipeTag;

@Repository
public interface RecipeTagRepository extends JpaRepository<RecipeTag, Integer> {

    // Query to select the tags from a single recipe
    @Query("SELECT t.name FROM Tag t INNER JOIN RecipeTag rt ON t.id = rt.tag.id WHERE rt.recipe.id = ?1")
    List<String> findTagNamesByRecipeId(Integer recipeId);


}
