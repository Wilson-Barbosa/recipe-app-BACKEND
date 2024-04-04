package com.cuisinehub.recipes.services.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.DTOs.recipes.RecipeCompleteResponse;
import com.cuisinehub.recipes.DTOs.recipes.RecipeSummaryResponse;
import com.cuisinehub.recipes.DTOs.recipes.ReviewResponse;
import com.cuisinehub.recipes.entities.recipes.Recipe;
import com.cuisinehub.recipes.entities.users.Profile;
import com.cuisinehub.recipes.repositories.recipes.RecipeRepository;
import com.cuisinehub.recipes.repositories.users.ProfileRepository;

@Service
public class RecipeService {

    // Injecting the Repositories
    @Autowired RecipeRepository recipeRepository;
    @Autowired ProfileRepository profileRepository;
    @Autowired ReviewService reviewService;
    @Autowired RecipeTagService recipeTagService;

    // Get a list of RecipeSummaryResponse
    public List<RecipeSummaryResponse> getRecipeSummary() {

        List<Recipe> recipes = recipeRepository.findAll(); // list recovered from the database
        List<RecipeSummaryResponse> responseList = new ArrayList<>(); // list to be return

        // Converts each RecipeEntity to a RecipeSummaryResponse and adds it to another
        // list
        recipes.forEach(recipe -> {
            responseList.add(recipe.toRecipeSummaryResponse());
        });

        return responseList;
    }

    // Get a single recipe by id
    public RecipeCompleteResponse getFullRecipe(int id) {

        // TODO the way I'm making the queries is not very efficient I think, should
        // consider adding JPQL here too

        // Instantiates an empty RecipeCompleteResponse object
        RecipeCompleteResponse response = new RecipeCompleteResponse();

        // Recipe
        Recipe recipe = recipeRepository.getReferenceById(id);
        List<String> ingredients = Arrays.asList(recipe.getIngredients().split("##"));

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
        response.setIngredients(ingredients);
        response.setTags(tags);
        response.setReviews(reviews);

        return response;
    }

    // Gets a List of RecipeSummaryResponse by receiving a string as parameter
    // first it searches for an exact title match,
    // if none is found then searches for an approximate match!
    public List<RecipeSummaryResponse> getListMatchingRecipeResponse(String keyword) {

        Recipe recipe = recipeRepository.findByTitleIgnoreCase(keyword); // RecipeEntity
        List<RecipeSummaryResponse> recipeList = new ArrayList<>(); // RecipeResponse

        if (recipe != null) {
            // If an exact match is found:
            recipeList.add(recipe.toRecipeSummaryResponse());
        } else {
            // If an exact match is not found then a list of corresponding matches is
            // searched
            List<Recipe> recipes = recipeRepository.findAllByTitleContainingIgnoreCase(keyword);

            // Converts each RecipeEntity to RecipeSummaryResponse and adds it to the list
            recipes.forEach(r -> {
                recipeList.add(r.toRecipeSummaryResponse());
            });
        }

        // Returns the list (it can be empty, the frontend should handle this)
        return recipeList;

    }
}
