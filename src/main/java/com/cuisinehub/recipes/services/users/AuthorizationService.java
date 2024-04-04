package com.cuisinehub.recipes.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.repositories.users.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    // Injecting the repository that calls 
    @Autowired UserRepository userRepository;

    // Method that calls the repository and searches a LoginEntity from the database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }
    
}
