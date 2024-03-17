package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    
}
