package com.cuisinehub.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.repositories.RecipeTagRepository;

@Service
public class RecipeTagService {
    
    @Autowired RecipeTagRepository recipeTagRepository;

    public List<String> getTagsForRecipe(int id){
        return recipeTagRepository.findTagNamesByRecipeId(id);
    }


}
