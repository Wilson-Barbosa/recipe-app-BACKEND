package com.cuisinehub.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cuisinehub.recipes.DTOs.RecipeCompleteResponse;
import com.cuisinehub.recipes.DTOs.RecipeSummaryResponse;
import com.cuisinehub.recipes.services.RecipeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin
@RequestMapping("recipes")
public class RecipeController {
    
    // Injecting the RecipeService
    @Autowired
    RecipeService recipeService;

    // Endpoint to recover ALL recipes
    @GetMapping()
    public ResponseEntity<List<RecipeSummaryResponse>> getAllRecipes(){
        return ResponseEntity.ok().body(recipeService.getRecipeSummary());
    }

    // Endpoint to recover a single recipe by id
    @GetMapping("{id}")
    public ResponseEntity<RecipeCompleteResponse> getRecipeById(@PathVariable int id){
        return ResponseEntity.ok(recipeService.getFullRecipe(id));
    }



}
