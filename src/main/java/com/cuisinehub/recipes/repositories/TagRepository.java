package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    
}
