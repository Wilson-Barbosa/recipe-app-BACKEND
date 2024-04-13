package com.cuisinehub.recipes.security;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cuisinehub.recipes.entities.users.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private Instant generateExpirationDate(){
        return Instant.now().plusSeconds(300);
    }

    // Method that generates the JWT token
    public String generateToken(User user){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                              .withIssuer("auth-api")
                              .withSubject(user.getEmail())
                              .withExpiresAt(generateExpirationDate())
                              .sign(algorithm);

            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating the token");
        }

    }

    // Method to validate a token from a request
    public String validateToken(String token){
        try {
            
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                      .withIssuer("auth-api")
                      .build()
                      .verify(token)
                      .getSubject();

        } catch (JWTVerificationException e) {
            return "";
        }
    }



}
