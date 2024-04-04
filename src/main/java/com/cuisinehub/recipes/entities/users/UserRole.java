package com.cuisinehub.recipes.entities.users;

public enum UserRole {

    // TODO Maybe I should consider changing this to a database approach

    BASICUSER("basic-user"),
    FULLUSER("full-user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public static UserRole fromRole(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.role.equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole: " + role);
    }
    
}
