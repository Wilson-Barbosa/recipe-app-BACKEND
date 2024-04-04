package com.cuisinehub.recipes.repositories.recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.recipes.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    
}
