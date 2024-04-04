package com.cuisinehub.recipes.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.users.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
    // Searches and gets a user's profile by their username
    Profile findByUserName(String username);

}
