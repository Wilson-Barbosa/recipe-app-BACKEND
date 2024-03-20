package com.cuisinehub.recipes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.DTOs.RecipeSummaryResponse;
import com.cuisinehub.recipes.entities.Recipe;
import com.cuisinehub.recipes.repositories.RecipeRepository;

@Service
public class RecipeService {

    // Injecting the Repositories
    @Autowired
    RecipeRepository recipeRepository;

    public List<RecipeSummaryResponse> getRecipeSummary() {

        List<Recipe> recipes = recipeRepository.findAll();  // list recovered from the database
        List<RecipeSummaryResponse> responseList = new ArrayList<>(); // list to be return

        // Converts each RecipeEntity to a RecipeSummaryResponse and adds it to another list
        recipes.forEach(recipe -> {
            responseList.add(recipe.toRecipeSummaryResponse());
        });
        
        return responseList;
    }

}
