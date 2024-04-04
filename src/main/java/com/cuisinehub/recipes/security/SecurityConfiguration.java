package com.cuisinehub.recipes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // Overrides the deafault implementations of security, so that I can make my own configurations
    // the method here makes the session STATELESS and applies filters to my endpoints
    // so only user with appropriate roles can access their resources
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf -> csrf.disable())
                   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                   .authorizeHttpRequests(authorize -> authorize
                            .requestMatchers(HttpMethod.POST, "api/v1/auth/users/register").permitAll() // Public endpoint, anyone can register
                            .requestMatchers(HttpMethod.POST, "api/v1/auth/users/login").permitAll() // Public endpoint, anyone can TRY login
                            .requestMatchers(HttpMethod.POST, "api/v1/recipes").hasRole("FULLUSER") // Only full users can post recipes
                            .requestMatchers(HttpMethod.GET, "api/v1/recipes/**").permitAll() // Public endpoint, anyone can view recipes
                            .anyRequest().authenticated())  // By default all other endpoints no specified will require authentication
                   .build();
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Allows the hashing process to be done by BCrypt, which is a good alternative to hashing passwords
    @Bean 
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
