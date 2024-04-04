package com.cuisinehub.recipes.services.recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.repositories.recipes.RecipeTagRepository;

@Service
public class RecipeTagService {
    
    @Autowired RecipeTagRepository recipeTagRepository;

    public List<String> getTagsForRecipe(int id){
        return recipeTagRepository.findTagNamesByRecipeId(id);
    }


}
