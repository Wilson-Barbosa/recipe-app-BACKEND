package com.cuisinehub.recipes.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.DTOs.users.LoginRequest;
import com.cuisinehub.recipes.DTOs.users.RegisterRequest;
import com.cuisinehub.recipes.entities.users.User;
import com.cuisinehub.recipes.entities.users.UserRole;
import com.cuisinehub.recipes.entities.users.Profile;
import com.cuisinehub.recipes.repositories.users.UserRepository;
import com.cuisinehub.recipes.security.TokenService;
import com.cuisinehub.recipes.repositories.users.ProfileRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;
    @Autowired
    EmailService emailService;

    // Gets called when a user is trying LOGIN
    public ResponseEntity<Void> logUserIn(LoginRequest loginRequest) {

        // Tries to validate the login attemp. If the information is invalid an
        // exception is thrown
        try {
            UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(), loginRequest.getPassword());

            // Authenticate with Spring Security
            Authentication authentication = authenticationManager.authenticate(usernamePassword);

            // Get the authenticated User object from the Authentication object
            User user = (User) authentication.getPrincipal();

            // Creates the token
            String token = tokenService.generateToken(user);

            // Returns an empty response containing the token inside the header
            return ResponseEntity.ok().header("Authorization", "Bearer " + token).build();
        } catch (BadCredentialsException e) {
            // TODO right now I'm not specifying which one is wrong, maybe improve this
            // message soon
            throw new BadCredentialsException("Email or password invalid");
        }

    }

    // Gets called when a user tries to REGISTER
    public ResponseEntity<Void> register(RegisterRequest registerRequest) {

        // Creating some variables to
        String username = registerRequest.getUsername();
        String email = registerRequest.getEmail();
        String password = registerRequest.getPassword();

        // First I check if the email is already registered
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email already registered");
        }

        // Then I check if the username is already registered
        if (profileRepository.findByUserName(username) != null) {
            throw new RuntimeException("Username already registered");
        }

        // Creating and populating the UserEntity (this line is only executed if no
        // exceptions are thrown))
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(new BCryptPasswordEncoder().encode(password)); // saving the hashed password
        user.setRole(UserRole.BASICUSER); // By default all new users are basic-users

        // Creating a profile Entity, for it needs the
        Profile profile = new Profile();
        profile.setUserName(username);
        profile.setLogin(user);

        // Save the UserEntity in the database (it must be saved BEFORE the profile)
        userRepository.save(user);

        // Save the username (it must be saved AFTER the user, or a constraint violation
        // will happen)
        profileRepository.save(profile);

        // Creating the message
        String text = "Hi, " + username + ",\n\n" + "Welcome to CuisineHub! Enjoy our recipes!" + "\n\n"
                + "CuisineHub's CEO and Founder,\n\n" + "Wilson";

        // Sends email
        emailService.sendSimpleRegistrationEmail(email, "Account Registration", text);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
