package com.cuisinehub.recipes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
    // Query for a list of reviews based on recipeId
    List<Review> findByRecipeId(Integer recipeId);

}
