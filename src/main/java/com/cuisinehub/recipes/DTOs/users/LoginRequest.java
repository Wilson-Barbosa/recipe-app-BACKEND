package com.cuisinehub.recipes.DTOs.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    // For these attributes I'm performing some very simple validation
    @NotBlank(message = "Email address cannot be empty")
    @Size(max = 50, message = "Email address cannot exceed 50 characters")
    @Email(message = "Email format invalid")
    private String email; // TODO I should consider adding more specific validations here later

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 25, message = "Password must be between 3 and 25 characters")
    private String password;

    // Empty Constructor
    public LoginRequest() {

    }

    // Setters and Getters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
