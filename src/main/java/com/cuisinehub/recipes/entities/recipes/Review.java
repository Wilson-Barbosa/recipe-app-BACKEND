package com.cuisinehub.recipes.entities.recipes;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cuisinehub.recipes.DTOs.recipes.ReviewResponse;
import com.cuisinehub.recipes.entities.users.Profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    // Empty Constructor
    public Review() {

    }

    public ReviewResponse toReviewResponse(){
        
        // Instantiate an empty ReviewResponse object
        ReviewResponse response = new ReviewResponse();

        // Populatin the empty object with data
        response.setId(id);
        response.setComment(comment);
        response.setCreatedAt(createdAt);
        response.setRating(rating);
        response.setAuthor(profile.toUserBasicResponse());

        return response;
    }


    // Setters and Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreateAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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
        Review other = (Review) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", profile=" + profile + ", comment=" + comment + ", rating=" + rating
                + ", createAt=" + createdAt + ", recipe=" + recipe + "]";
    }

}
