package com.cuisinehub.recipes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.DTOs.RecipeCompleteResponse;
import com.cuisinehub.recipes.DTOs.RecipeSummaryResponse;
import com.cuisinehub.recipes.DTOs.ReviewResponse;
import com.cuisinehub.recipes.entities.Profile;
import com.cuisinehub.recipes.entities.Recipe;
import com.cuisinehub.recipes.repositories.ProfileRepository;
import com.cuisinehub.recipes.repositories.RecipeRepository;


@Service
public class RecipeService {

    // Injecting the Repositories
    @Autowired RecipeRepository recipeRepository;
    @Autowired ProfileRepository profileRepository;
    @Autowired ReviewService reviewService;
    @Autowired RecipeTagService recipeTagService;

    // Get a list of RecipeSummaryResponse
    public List<RecipeSummaryResponse> getRecipeSummary() {

        List<Recipe> recipes = recipeRepository.findAll();  // list recovered from the database
        List<RecipeSummaryResponse> responseList = new ArrayList<>(); // list to be return

        // Converts each RecipeEntity to a RecipeSummaryResponse and adds it to another list
        recipes.forEach(recipe -> {
            responseList.add(recipe.toRecipeSummaryResponse());
        });
        
        return responseList;
    }

    // Get a single recipe by id
    public RecipeCompleteResponse getFullRecipe(int id){

        // TODO the way I'm making the queries is not very efficient I think, shoul consider adding JPQL here too

        // Instantiates an empty RecipeCompleteResponse object
        RecipeCompleteResponse response = new RecipeCompleteResponse();

        // Recipe
        Recipe recipe = recipeRepository.getReferenceById(id);

        // Author
        Profile profile = profileRepository.getReferenceById(id);

        // Reviews
        List<ReviewResponse> reviews = reviewService.getReviewResponses(id);

        // Tags
        List<String> tags = recipeTagService.getTagsForRecipe(id);
        
        // From the various repositories I'm populating the Full Response
        response.setId(recipe.getId());
        response.setAuthor(profile.toUserBasicResponse());
        response.setTitle(recipe.getTitle());
        response.setPhoto(recipe.getPhoto());
        response.setRating(recipe.getRating());
        response.setCookTime(recipe.getCookTime());
        response.setCreatedAt(recipe.getCreatedAt());
        response.setDirections(recipe.getDirections());
        response.setIngredients(recipe.getIngredients());
        response.setTags(tags);
        response.setReviews(reviews);
        
        return response;
    }


}
