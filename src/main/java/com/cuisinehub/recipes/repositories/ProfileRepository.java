package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}
