package com.cuisinehub.recipes.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cuisinehub.recipes.DTOs.RecipeSummaryResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer cookTime;

    @Column(nullable = false)
    private String directions;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = true)
    private String photo;

    @Column(nullable = false)
    private String ingredients;

    // Empty Constructor
    public Recipe() {

    }

    // Converts RecipeEntity to RecipeSummaryReponse
    public RecipeSummaryResponse toRecipeSummaryResponse(){
        
        // Instantiates a RecipeSummaryResponse object
        RecipeSummaryResponse response = new RecipeSummaryResponse();

        // Setting the values
        response.setId(id);
        response.setTitle(title);
        response.setPhoto(photo);
        response.setRating(rating);
        response.setCookTime(cookTime);

        // Returns the populated object
        return response;
    }


    // Setters and Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
        Recipe other = (Recipe) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + id + ", title=" + title + ", profile=" + profile + ", createdAt=" + createdAt
                + ", cookTime=" + cookTime + ", directions=" + directions + ", rating=" + rating + ", photo=" + photo
                + ", ingredients=" + ingredients + "]";
    }

}
