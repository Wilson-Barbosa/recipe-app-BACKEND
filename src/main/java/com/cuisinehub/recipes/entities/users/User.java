package com.cuisinehub.recipes.entities.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cuisinehub.recipes.converters.UserRoleConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Convert(converter = UserRoleConverter.class)
    private UserRole role;

    // Empty Constructor
    public User() {

    }

    public User(String email, String passwordHash, UserRole role) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    // Setters and Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    /* ---------------------- Overriden methods ---------------------- */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "user [id=" + id + ", email=" + email + ", passwordHash=" + passwordHash + ", role=" + role + "]";
    }

    // This is a very important method that grants authorities for each role
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // The authories will be always a collection
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Checking what type of role a user is and then granting access based on it
        if (this.role == UserRole.FULLUSER) {
            // A full user has authority of both basic and full users
            authorities.add(new SimpleGrantedAuthority("ROLE_FULLUSER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_BASICUSER"));
        } else {
            // A basic user only has authority of a basic user
            authorities.add(new SimpleGrantedAuthority("ROLE_BASICUSER"));
        }

        // After all assinings I return the List
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
