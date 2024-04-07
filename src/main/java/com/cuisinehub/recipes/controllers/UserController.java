package com.cuisinehub.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuisinehub.recipes.DTOs.users.LoginRequest;
import com.cuisinehub.recipes.DTOs.users.RegisterRequest;
import com.cuisinehub.recipes.services.users.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/auth/users")
@CrossOrigin
public class UserController {

    // Injecting the service
    @Autowired UserService userService;

    // Endpoint to register new users
    @PostMapping("/register")
    public ResponseEntity<Void> registerNewUser(@RequestBody @Valid RegisterRequest request){
        
        // calls the service to register a new user
        userService.register(request);

        // If the request is successful then this line is executed and the response is sent to client
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    // Endpoint to Log users
    @PostMapping("/login")
    public ResponseEntity<String> logUser(@RequestBody @Valid LoginRequest login){

        userService.saveUser(login);

        return ResponseEntity.ok().body("User Logged");

    }


}
