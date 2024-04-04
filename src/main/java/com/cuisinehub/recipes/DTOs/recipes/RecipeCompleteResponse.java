package com.cuisinehub.recipes.DTOs.recipes;

import java.time.LocalDateTime;
import java.util.List;

public class RecipeCompleteResponse {

    private int id;
    private UserBasicResponse author;
    private String title;
    private String photo;
    private double rating;
    private int cookTime;
    private LocalDateTime createdAt;
    private String directions;
    private List<String> ingredients;
    private List<String> tags;
    private List<ReviewResponse> reviews;
    

    // TODO should I add another field for the related recipes? or make another request

    // Empty Constructor
    public RecipeCompleteResponse(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<ReviewResponse> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewResponse> reviews) {
        this.reviews = reviews;
    }

    public UserBasicResponse getAuthor() {
        return author;
    }

    public void setAuthor(UserBasicResponse author) {
        this.author = author;
    }







    

}
