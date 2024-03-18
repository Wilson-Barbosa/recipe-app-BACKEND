package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}
