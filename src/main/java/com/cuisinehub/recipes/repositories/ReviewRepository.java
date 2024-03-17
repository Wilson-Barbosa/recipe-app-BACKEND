package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}
