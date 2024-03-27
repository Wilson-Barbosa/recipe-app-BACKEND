package com.cuisinehub.recipes.DTOs;


import java.time.LocalDateTime;

public class ReviewResponse {

    private int id;
    private double rating;
    private LocalDateTime createdAt;
    private String comment;
    private UserBasicResponse author;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public UserBasicResponse getAuthor() {
        return author;
    }
    public void setAuthor(UserBasicResponse author) {
        this.author = author;
    }


}
