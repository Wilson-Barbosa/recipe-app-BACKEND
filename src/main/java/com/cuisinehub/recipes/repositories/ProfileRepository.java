package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}
