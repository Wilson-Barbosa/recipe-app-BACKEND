package com.cuisinehub.recipes.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisinehub.recipes.entities.users.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Searches a gets a user's information by their email
    User findByEmail(String email);

}
