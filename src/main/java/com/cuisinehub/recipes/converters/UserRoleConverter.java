package com.cuisinehub.recipes.converters;

import com.cuisinehub.recipes.entities.users.UserRole;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    // A bug was happening where the mapping of UserRole wasn't being done correctly
    // I implemented this converter so that I can return a string correctly from my UserRole enum 

    @Override
    public String convertToDatabaseColumn(UserRole role) {
        return role.getRole();
    }

    @Override
    public UserRole convertToEntityAttribute(String role) {
        return UserRole.fromRole(role);
    }
}
