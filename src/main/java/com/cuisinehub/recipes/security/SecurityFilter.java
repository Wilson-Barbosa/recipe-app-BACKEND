package com.cuisinehub.recipes.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cuisinehub.recipes.repositories.users.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired TokenService tokenService;

    @Autowired UserRepository userRepository;

    // Method that gets the authorization from the HTTP header's request
    private String recoverToken(HttpServletRequest request){

        String authHeader = request.getHeader("Authorization");


        if(authHeader == null) {
            return null;
        }

        return authHeader.replace("Bearer ", "");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String token = recoverToken(request);

                if(token != null){

                    String subject = tokenService.validateToken(token);

                    // if no exception is thrown then 
                    UserDetails user = userRepository.findByEmail(subject);

                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } 

                // If there is no token inside the HTTP request the other filters from SecurityConfiguration are applied
                filterChain.doFilter(request, response);

    }



}
