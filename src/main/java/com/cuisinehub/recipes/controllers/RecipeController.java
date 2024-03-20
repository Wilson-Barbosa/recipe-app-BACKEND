package com.cuisinehub.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cuisinehub.recipes.DTOs.RecipeSummaryResponse;
import com.cuisinehub.recipes.services.RecipeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin
public class RecipeController {
    
    // Injecting the RecipeService
    @Autowired
    RecipeService recipeService;

    @GetMapping("recipes")
    public ResponseEntity<List<RecipeSummaryResponse>> getAllRecipes(){
        return ResponseEntity.ok().body(recipeService.getRecipeSummary());
    }

}
