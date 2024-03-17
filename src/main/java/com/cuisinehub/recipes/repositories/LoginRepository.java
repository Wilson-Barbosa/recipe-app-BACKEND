package com.cuisinehub.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuisinehub.recipes.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    
}
