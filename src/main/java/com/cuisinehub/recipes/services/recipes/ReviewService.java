package com.cuisinehub.recipes.services.recipes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.DTOs.recipes.ReviewResponse;
import com.cuisinehub.recipes.entities.recipes.Review;
import com.cuisinehub.recipes.repositories.recipes.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired ReviewRepository reviewRepository;

    // Gets all reviews from a specific id (if any) an returns a list of ReviewResponse
    public List<ReviewResponse> getReviewResponses(int id){

        // Instantiate an empty List<ReviewResponse>
        List<ReviewResponse> response = new ArrayList<>();

        // List of EntityReviews
        List<Review> reviews = reviewRepository.findByRecipeId(id);

        // Converts the entities to responses
        reviews.forEach(review -> {
            response.add(review.toReviewResponse());
        });

        return response;

    }


}
